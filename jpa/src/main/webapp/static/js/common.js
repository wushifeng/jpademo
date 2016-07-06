/**
 * Created by Answer on 16/7/5.
 */
/**
 * 数据类型单元格样式
 */
function cellTypeFormatter(value, row, index) {
    return Global.DBTypt[value]['text'];
}

/**
 *  故障中断单元格样式
 */
function cellInterruptFormatter(value, row, index) {
    if (value) {
        return "<a onclick='changeInterrupt(this)'><i class=\"glyphicon glyphicon-ok\" style=\"color: green;\"></a>";
    } else {
        return "<a onclick='changeInterrupt(this)'><i class=\"glyphicon glyphicon-remove\" style=\"color: red;\"></a>";
    }
}

/**
 *  部署状态单元格样式
 */
function cellStatusFormatter(value, row, index) {
    if (value) {
        return "<span style=\"color: green;\">已部署</span>";
    } else {
        return "<span style=\"color: red;\">未部署</span>";
    }
}

/**
 *  可编辑的加密算法单元格样式
 *  onColor: 'primary',
 offColor: 'danger',
 onText: '启用',
 offText: '停止'
 */
function cellEditEncryptAlgorithm(value, row, index) {
    html = "<input id=\"switch-offText\" type=\"checkbox\" data-size='mini' data-onColor='primary' data-offColor='danger' data-onText='DES' data-offText='ASE'>"
    return html;//Global.EncryptAlgorithm[value]['text'];
}

/**
 *  加密算法单元格样式
 */
function cellEncryptAlgorithm(value, row, index) {
    return Global.EncryptAlgorithm[value]['text'];
}