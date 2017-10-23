describe('Enter GURU99 Name', function() {
 it('should add a Name as GURU99', function() {
 browser.get('https://angularjs.org');
 element(by.model('yourName')).sendKeys('GURU99');
  var guru= element(by.xpath("//label[text()='Name:']/following-sibling::h1[1]"));
expect(guru.getText()).toEqual('Hello GURU990!');
  });
});
