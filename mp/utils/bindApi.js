import constants from './constants';

function bindUser(args, cb) {
    wx.request({
        url: constants.domain + '/me',
        method: 'put',
        dataType: 'json',
        data: args,
        complete(e) {
            if (e.statusCode == '204') {
                // bind success
                console.log(e);
                cb(true);
            }else{
                cb(false);
            }
        }
    });

}

export default {bindUser};