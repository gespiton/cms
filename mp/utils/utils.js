function buildUrl(args) {
    let baseUrl = args.base;

    let firstParam = true;
    for (const key in args) {
        if (key !== 'base') {
            baseUrl += `${firstParam ? '?' : '&'}${key}=${args[key]}`;
            firstParam = false;
        }
    }
    return baseUrl;
}

function showSuccessToast() {
    wx.showToast({
        title: '成功, 请稍等',
        icon: 'success',
        duration: 2000
    });
}

function failToast(msg) {
    wx.showToast({
        title: msg,
        // icon: 'fail',
        image:'./icons/error.png',
        duration: 2000
    });
}

export default {buildUrl, showSuccessToast, failToast}