const nationWidth = {
    'korea': 220877,
    'Rusia': 17098242,
    'China': 9596961,
    'France': 543965,
    'Japan': 377915,
    'England' : 242900,
}

const k_width = nationWidth['korea'];
delete nationWidth['korea'];

var key = Object.keys(nationWidth);
var value = Object.values(nationWidth);


for(var i in key){
nationWidth[key[i]] = Math.abs(value[i]-k_width);
}

const min = Math.min(...Object.values(nationWidth));

var result = key.find(x=>nationWidth[x] == min);

console.log(`${result}  ${min}`);