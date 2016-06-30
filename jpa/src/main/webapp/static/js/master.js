var master = {
    ajax: {
        beforeText: "正在处理,请稍后......",
        successText: "操作成功",
        errorText: "操作过程出错,此次操作无效!",
        data: {},
        beforeSend: function (text) {
            alert("beforeSend:" + text);
        },
        afterComplete: function () {
            alert("close");
        }
    },
    _ajax: function (data) {
        var options = {};
        $.extend(options, master.ajax, data, master[data.textType]);
        if ($.type(options.data) == "object") {//将参数解析成url
            options.data = $.csbitParam(options.data);
        }
        $.ajax({
            url: options.url,
            data: options.data,
            type: options.type,
            dataType: 'json',
            beforeSend: function () {
                options.beforeSend(options.beforeText);
            },
            complete: function (XMLHttpRequest, textStatus) {
                if (typeof options.complete == "function") {
                    options.complete(XMLHttpRequest.responseText);
                }
                options.afterComplete();
                var value = XMLHttpRequest.responseText;
                if (value.indexOf("太长时间没有操作,请重新登录!") > -1) {
                    parent.location.href = baseUrl;//重定向到登录页面
                    return;
                }

                var json = value;
                if (typeof value == "string") {
                    try {
                        json = JSON.parse(value);
                    } catch (e) {

                    }
                }
                if (json.error) {
                    alert("<h2>" + options.errorText + "</h2>" + json.messager || "");
                    return;
                }
                switch (XMLHttpRequest.status) {
                    case 200:
                        break;
                    case 401:
                    case 404:
                    case 405:
                        if ($.isFunction(options.complete)) options.complete(value);
                        alert(value);
                        break;
                    case 500:
                        if ($.isFunction(options.error)) options.error(value);
                        alert(options.errorText);
                        break;
                }
            }
        })
    },
    postJSON: function (ajax) {
        ajax.type = 'post';
        master._ajax(ajax);
    }
};

$.csbitParam = function (object) {
    var params = "_rand_csbit=" + Math.random();
    for (var i in object) {
        if ($.isArray(object[i])) {
            $.each(object[i], function (index, value) {
                params += "&" + i + "=" + encodeURIComponent(value);
            });
        }
        else {
            params += "&" + i + "=" + encodeURIComponent(object[i]);
        }

    }
    return params;
};