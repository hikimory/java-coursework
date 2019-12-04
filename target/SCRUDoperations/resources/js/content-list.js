var brandOptions = {
    valueNames: ['brand-name', 'founded-year', 'headquarter']
};

var brandList = new List('car-brands', brandOptions);

var modelOptions = {
    valueNames: ['brand-name', 'model-name', 'generation', 'production-year',
                 'doors', 'seats','maximum-speed']
};

var modelList = new List('car-models', modelOptions);