/**
 * Created by Answer on 16/7/5.
 */
parents = new Array();

function initSchemaTree(tree, targetTable) {
    tree.treeview({
        color: "#428bca",
        nodeIcon: 'glyphicon glyphicon-bookmark',
        levels: 2,
        showTags: true,
        data: getTreeParents(),
        onNodeSelected: function (event, data) {
            // Your logic goes here
            console.log(data);

            // 没有父节点,则此节点为父节点
            // 选中父节点,刷新子节点信息
            if (data['parentId'] == null) {
                getTreeChildren(tree, data);
            } else {
                //选中子节点获取表详细信息
                getTreeChildDetail(data['text'], data['text'], targetTable);
            }
        }
    });
}

function getTreeParents() {
    master.postJSON({
        url: '/schema/get',
        async: false,
        complete: function (data) {
            data = JSON.parse(data);
            for (var i = 0; i < data.length; i++) {
                var node = {};
                node.text = data[i];//节点显示的内容
                node.herf = "#" + data[i];
                node.tags = ['0'];
                parents.push(node);
            }
        }
    });
    return parents;
}

function getTreeChildren(tree, parent) {
    master.postJSON({
        url: '/schema/getChild',
        data: {
            schema: parent['text']
        },
        complete: function (data) {
            tree.treeview("delChildrenNode", parent['nodeId']);
            data = JSON.parse(data);
            for (var i = 0; i < data.length; i++) {
                var node = {};
                node.text = data[i];//节点显示的内容
                node.herf = "#" + data[i];
                node.tags = ['0'];
                tree.treeview("addNode", [parent['nodeId'], {node: node}]);
            }
        }
    });
}

function getTreeChildDetail(schema, table, targetTable) {
    //master.postJSON({
    //    url: '/schema/getChildDetail',
    //    data: {
    //        schema: schema,
    //        table: table
    //    },
    //    complete: function (data) {
    //
    //    }
    //});
    targetTable.bootstrapTable('refresh', {
        url: '/schema/getChildDetail?schema=' + schema + '&table=' + table
    });
    //targetTable.bootstrapTable('refresh')
}