const data = {

}

const op = {
  set: function(key, value) {
    data[key] = value;
  },
  get: function(key) {
    return data[key]
  }
}

export default op;
