var elem = document.getElementById("tb1");
var clickEvent  = document.createEvent ('MouseEvents');
clickEvent.initEvent ('click', true, true);
elem.dispatchEvent (clickEvent);
