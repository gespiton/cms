// todo set cache(student)
import cache from './localCache';
import utils from './utils';

function getInfo(cb) {

    utils.requestWithId({
        url: '/me',
        success: function (response) {
            console.log(response);
            cache.set('me', response.data);

            utils.requestWithId({
                url: '/class',
                success: function (res) {
                    console.log(res.data);
                    cb({'me': response.data, 'classes': res.data});
                }
            });
        }
    });
}

export default {getInfo};
