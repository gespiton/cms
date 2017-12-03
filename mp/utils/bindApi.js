import constants from './constants';
import cache from './localCache';
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
                cache.set('userID', e.header.id);  // it's a hack to keep track of current user
                cb(true);
            } else {
                cb(false);
            }
        }
    });
}

export default {bindUser};