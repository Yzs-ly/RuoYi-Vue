<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="数据资源目录名称" prop="dirName">
        <el-input
          v-model="queryParams.dirName"
          placeholder="请输入数据资源目录名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:directory:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:directory:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:directory:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:directory:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="directoryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="数据资源目录名称" align="center" prop="dirName" />
      <el-table-column label="更新周期" align="center" prop="cycle" />
      <el-table-column label="基础信息分类" align="center" prop="basicClassification" />
      <el-table-column label="数据资源目录描述" align="center" prop="dirDescribe" width="500"/>
      <el-table-column label="数据资源目录编码" align="center" prop="code" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="同步频率" align="center" prop="synFrequency" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:directory:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:directory:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    

    <!-- 添加或修改数据目录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1200" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
          <el-col :span="12">
            <el-form-item label="目录名称" prop="dirName">
              <el-input v-model="form.dirName" placeholder="请输入目录名称" show-word-limit clearable
                :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="数据范围" prop="scope">
              <el-select v-model="form.scope" placeholder="请选择数据范围" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in scopeOptions" :key="index" :label="item.label"
                  :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="目录描述" prop="dirDescribe">
              <el-input v-model="form.dirDescribe" type="textarea" placeholder="请输入目录描述"
                :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="更新周期" prop="cycle">
              <el-select v-model="form.cycle" placeholder="请选择更新周期" clearable :style="{width: '100%'}">
                <el-option v-for="(item, index) in cycleOptions" :key="index" :label="item.label"
                  :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="资源分类" prop="classification">
              <el-input v-model="form.classification" placeholder="请输入资源分类" clearable
                :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="资源标签" prop="tag">
              <el-input v-model="form.tag" placeholder="请输入资源标签" clearable :style="{width: '100%'}">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="来源业务场景" prop="sourceBusiness">
              <el-input v-model="form.sourceBusiness" placeholder="请输入来源业务场景" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="关联业务场景" prop="associatedService">
              <el-input v-model="form.associatedService" placeholder="请输入关联业务场景" clearable
                :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="关联系统" prop="associatedSystem">
              <el-select v-model="form.associatedSystem" placeholder="请选择关联系统" clearable
                :style="{width: '100%'}">
                <el-option v-for="(item, index) in associatedSystemOptions" :key="index" :label="item.label"
                  :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="关联表" prop="associatedTable">
              <el-input v-model="form.associatedTable" placeholder="请输入关联表" clearable
                :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="关联字段" prop="associatedField">
              <el-input v-model="form.associatedField" placeholder="请输入关联字段" clearable
                :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="基础信息分类" prop="basicClassification">
              <el-radio-group v-model="form.basicClassification" size="medium">
                <el-radio v-for="(item, index) in basicClassificationOptions" :key="index" :label="item.value"
                  :disabled="item.disabled">{{item.label}}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="主题分类" prop="topicClassification">
              <el-select v-model="form.topicClassification" placeholder="请选择主题分类" clearable
                :style="{width: '100%'}">
                <el-option v-for="(item, index) in topicClassificationOptions" :key="index"
                  :label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="共享属性" prop="sharedProperties">
              <el-radio-group v-model="form.sharedProperties" size="medium">
                <el-radio v-for="(item, index) in sharedPropertiesOptions" :key="index" :label="item.value"
                  :disabled="item.disabled">{{item.label}}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="共享条件" prop="sharedConditions">
              <el-input v-model="form.sharedConditions" placeholder="请输入共享条件" clearable
                :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="共享方式" prop="sharingMode">
              <el-radio-group v-model="form.sharingMode" size="medium">
                <el-radio v-for="(item, index) in sharingModeOptions" :key="index" :label="item.value"
                  :disabled="item.disabled">{{item.label}}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="开放属性" prop="openAttribute">
              <el-radio-group v-model="form.openAttribute" size="medium">
                <el-radio v-for="(item, index) in openAttributeOptions" :key="index" :label="item.value"
                  :disabled="item.disabled">{{item.label}}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="数据是否存在物理删除" prop="isPhysicalDelete">
              <el-radio-group v-model="form.isPhysicalDelete" size="medium">
                <el-radio v-for="(item, index) in isPhysicalDeleteOptions" :key="index" :label="item.value"
                  :disabled="item.disabled">{{item.label}}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="数据同步机制" prop="synMechanism">
              <el-radio-group v-model="form.synMechanism" size="medium">
                <el-radio v-for="(item, index) in synMechanismOptions" :key="index" :label="item.value"
                  :disabled="item.disabled">{{item.label}}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="同步频率" prop="synFrequency">
              <el-input v-model="form.synFrequency" placeholder="例如：每日零点开始间隔30分钟" clearable
                :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否发布到超市" prop="isSynTosupermarket">
              <el-radio-group v-model="form.isSynTosupermarket" size="medium">
                <el-radio v-for="(item, index) in isSynTosupermarketOptions" :key="index" :label="item.value"
                  :disabled="item.disabled">{{item.label}}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDirectory, getDirectory, delDirectory, addDirectory, updateDirectory } from "@/api/yhq-dm/directory";

export default {
  name: "Directory",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 数据目录表格数据
      directoryList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        dirName: null,
        basicClassification: null,
      },
      // 表单参数
      form: {
        dirName: undefined,
        scope: undefined,
        dirDescribe: undefined,
        cycle: undefined,
        classification: undefined,
        tag: undefined,
        sourceBusiness: undefined,
        associatedService: undefined,
        associatedSystem: undefined,
        associatedTable: undefined,
        associatedField: undefined,
        basicClassification: undefined,
        topicClassification: undefined,
        sharedProperties: undefined,
        sharedConditions: undefined,
        sharingMode: undefined,
        openAttribute: '',
        isPhysicalDelete: undefined,
        synMechanism: '',
        synFrequency: undefined,
        isSynTosupermarket: undefined,
      },
      // 表单校验
      rules: {
        dirName: [{
          required: true,
          message: '请输入目录名称',
          trigger: 'blur'
        }],
        scope: [{
          required: true,
          message: '请选择数据范围',
          trigger: 'change'
        }],
        dirDescribe: [{
          required: true,
          message: '请输入目录描述',
          trigger: 'blur'
        }],
        cycle: [{
          required: true,
          message: '请选择更新周期',
          trigger: 'change'
        }],
        classification: [{
          required: true,
          message: '请输入资源分类',
          trigger: 'blur'
        }],
        tag: [{
          required: true,
          message: '请输入资源标签',
          trigger: 'blur'
        }],
        sourceBusiness: [{
          required: true,
          message: '请输入来源业务场景',
          trigger: 'blur'
        }],
        associatedService: [{
          required: true,
          message: '请输入关联业务场景',
          trigger: 'blur'
        }],
        associatedSystem: [{
          required: true,
          message: '请选择关联系统',
          trigger: 'change'
        }],
        associatedTable: [{
          required: true,
          message: '请输入关联表',
          trigger: 'blur'
        }],
        associatedField: [{
          required: true,
          message: '请输入关联字段',
          trigger: 'blur'
        }],
        basicClassification: [{
          required: true,
          message: '基础信息分类不能为空',
          trigger: 'change'
        }],
        topicClassification: [{
          required: true,
          message: '请选择主题分类',
          trigger: 'change'
        }],
        sharedProperties: [{
          required: true,
          message: '共享属性不能为空',
          trigger: 'change'
        }],
        sharedConditions: [],
        sharingMode: [{
          required: true,
          message: '共享方式不能为空',
          trigger: 'change'
        }],
        openAttribute: [{
          required: true,
          message: '开放属性不能为空',
          trigger: 'change'
        }],
        isPhysicalDelete: [{
          required: true,
          message: '数据是否存在物理删除不能为空',
          trigger: 'change'
        }],
        synMechanism: [{
          required: true,
          message: '数据同步机制不能为空',
          trigger: 'change'
        }],
        synFrequency: [{
          required: true,
          message: '例如：每日零点开始间隔30分钟',
          trigger: 'blur'
        }],
        isSynTosupermarket: [{
          required: true,
          message: '是否发布到超市不能为空',
          trigger: 'change'
        }],
      },
      scopeOptions: [{
        "label": "全市",
        "value": "全市"
      }, {
        "label": "市直",
        "value": "市直"
      }, {
        "label": "区县",
        "value": "区县"
      }],
      cycleOptions: [{
        "label": "实时",
        "value": "实时"
      }, {
        "label": "每日",
        "value": "每日"
      }, {
        "label": "每周",
        "value": "每周"
      }, {
        "label": "每月",
        "value": "每月"
      }, {
        "label": "每季度",
        "value": "每季度"
      }, {
        "label": "每半年",
        "value": "每半年"
      }],
      associatedSystemOptions: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
      basicClassificationOptions: [{
        "label": "人",
        "value": "人"
      }, {
        "label": "事",
        "value": " 事"
      }, {
        "label": "地",
        "value": "地"
      }, {
        "label": "物",
        "value": "物"
      }, {
        "label": "组织",
        "value": "组织"
      }, {
        "label": "其他",
        "value": "其他"
      }],
      topicClassificationOptions: [{
        "label": "医疗健康",
        "value": "医疗健康"
      }, {
        "label": "社会保障",
        "value": "社会保障"
      }, {
        "label": "金融信息",
        "value": "金融信息"
      }, {
        "label": "信用信息",
        "value": "信用信息"
      }, {
        "label": "生态环境",
        "value": "生态环境"
      }, {
        "label": "应急维稳",
        "value": "应急维稳"
      }, {
        "label": "行政执法",
        "value": "行政执法"
      }, {
        "label": "司法保障",
        "value": "司法保障"
      }, {
        "label": "其他",
        "value": "其他"
      }],
      sharedPropertiesOptions: [{
        "label": "无条件共享",
        "value": "无条件共享"
      }, {
        "label": "有条件共享",
        "value": "有条件共享"
      }, {
        "label": "不予共享",
        "value": "不予共享"
      }],
      sharingModeOptions: [{
        "label": "共享平台方式",
        "value": "共享平台方式"
      }, {
        "label": "邮件方式",
        "value": "邮件方式"
      }, {
        "label": "介质方式",
        "value": "介质方式"
      }],
      openAttributeOptions: [{
        "label": "向公众开放",
        "value": "向公众开放"
      }, {
        "label": "不向公众开放",
        "value": "不向公众开放"
      }],
      isPhysicalDeleteOptions: [{
        "label": "否",
        "value": "否"
      }, {
        "label": "是",
        "value": "是"
      }],
      synMechanismOptions: [{
        "label": "增量",
        "value": "增量"
      }, {
        "label": "全量",
        "value": "全量"
      }],
      isSynTosupermarketOptions: [{
        "label": "是",
        "value": "是"
      }, {
        "label": "否",
        "value": "否"
      }],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询数据目录列表 */
    getList() {
      this.loading = true;
      listDirectory(this.queryParams).then(response => {
        this.directoryList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        dirName: null,
        scope: null,
        cycle: null,
        provide: null,
        classification: null,
        type: null,
        tag: null,
        basicClassification: null,
        topicClassification: null,
        dirDescribe: null,
        sharedProperties: null,
        sharedConditions: null,
        sharingMode: null,
        openAttribute: null,
        openCondition: null,
        userNumber: null,
        associatedSystem: null,
        sourceBusiness: null,
        associatedService: null,
        associatedTable: null,
        associatedField: null,
        code: null,
        version: null,
        isLatest: null,
        status: "0",
        createDate: null,
        updateDate: null,
        isPhysicalDelete: null,
        synMechanism: null,
        synFrequency: null,
        isSynTosupermarket: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.code)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加数据目录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const code = row.code || this.ids
      getDirectory(code).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改数据目录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.code != null) {
            updateDirectory(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDirectory(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const codes = row.code || this.ids;
      this.$modal.confirm('是否确认删除数据目录编号为"' + codes + '"的数据项？').then(function() {
        return delDirectory(codes);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('yhq-dm/directory/export', {
        ...this.queryParams
      }, `directory_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
