import $ from 'jquery'
import qs from 'qs'


function get(holder) {//url,async,method,data,callback
    $.ajax({
        url: holder.url,
        type: 'GET',
        async: holder.async,
        data: holder.data,
        dataType: 'json',
        success: function (data) {
            holder.succ(data);
        },
        error: function (data) {
            holder.fail(data);
        }
    });
}
function post(holder) {
    console.log("qs.stringify(holder.data)=>",qs.stringify(holder.data));
    $.ajax({
        url: holder.url,
        type: 'POST',
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        crossDomain: true,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        async: holder.async,
        data: qs.stringify(holder.data),
        success: function (data) {
            holder.succ(data);
        },
        error: function (data) {
            holder.fail(data);
        }
    });
}

const api = {
    get: get,
    post: post
}

export default api;