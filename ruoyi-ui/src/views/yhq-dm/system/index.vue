<template>
    <div class="app-ccontainer">
        <el-row :gutter="20">
            <!--部门数据---->
            <el-col :span="4" :xs="24">
                <div class="head-container">
                    <el-input
                        v-model="deptName"
                        placeholder="请输入部门名称"
                        clearable
                        size="small"
                        prefix-icon="el-icon-search"
                        style="margin-bottom: 20px"
                    />
                </div>
                <div class="head-container">
                    <el-tree
                        :data="deptOptions"
                        :props="defaultProps"
                        :expand-on-click-node="false"
                        :filter-node-method="filterNode"
                        ref="tree"
                        default-expand-all
                        highlight-current
                        @node-click="handleNodeClick"
                    />
                </div>
            </el-col>
            <!--业务系统数据-->
            <el-col :span="20" :xs="24">

            </el-col>
        </el-row>
    </div>
</template>

<script>
import { listSystem, getSystem, addSystem, delSystem, updateSystem } from "@/api/yhq-dm/system";
import { treeselect } from "@/api/system/dept";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default defineComponent({
    setup() {
        
    },
})
</script>
