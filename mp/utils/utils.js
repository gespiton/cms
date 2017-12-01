function buildUrl(args) {
    let baseUrl = args.base;

    let firstParam = true;
    for (const key in args) {
        if (key !== 'base') {
            baseUrl += `${firstParam?'?':'&'}${key}=${args[key]}`;
            firstParam = false;
        }
    }
    return baseUrl;
}

export default {buildUrl}