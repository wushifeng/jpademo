/**
 * Created by Answer on 16/6/29.
 */
// 打开登录框
function openLoginModal(obj) {
    // 获取用户角色
    role = $(obj).attr('user-role');
    title = "";
    switch (role) {
        case "1":
            title = "系统管理员";
            break;
        case "2":
            title = "安全管理员";
            break;
        case "3":
            title = "审计管理员";
            break;
    }
    // 设置角色名
    $('#loginText').text(title);

    // 传递用户角色参数
    $('#loginModal').attr("user-role", role);

    // 显示登录框
    $('#loginModal').modal();

}

//初始化登录表单验证
function initValidator() {
    $('#loginForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    stringLength: {
                        min: 6,
                        max: 20,
                        message: '用户名长度为6~20位'
                    },
                    notEmpty: {
                        message: '用户名不能为空'
                    }
                }
            },
            password: {
                validators: {
                    stringLength: {
                        min: 6,
                        max: 20,
                        message: '密码长度为6~20位'
                    },
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    });
}

// 发送登录请求
function login() {
    if ($('#loginForm').data('bootstrapValidator').isValid()) {
        master.postJSON({
            url: "http://localhost:8080/getLoginResult",
            data: {
                role: $("#loginModal").attr("user-role"),
                name: $("#name").val(),
                password: $("#password").val()
            },
            complete: function (data) {
                data = JSON.parse(data);
                if (data.success == "success") {
                    $('#loginModal').modal('hide');
                    if (data.url != null) {
                        window.location.href = data.url;
                    }
                }
            }
        });
    }
}