// Question :- Implementing getAverageCaloriesByColor() function
// Data :-
const Inventory = [ 
{ name: "Banana", color: "Yellow", calories: 105 },
{ name: "Apple", color: "Red", calories: 95 }, 
{ name: "Lemon", color: "Yellow", calories: 37 }, 
{ name: "Strawberry", color: "Red", calories: 33 }, 
{ name: "Avocado", color: "Green", calories: 160 },
{ name: "Grapes", color: "Purple", calories: 62 }, 
{ name: "Kiwi", color: "Green", calories: 42 }
 ];  

// Answer:-
function getAverageCaloriesByColor(color) {
    const filteredItems = Inventory.filter(item => item.color === color);
    const totalCalories = filteredItems.reduce((acc, item) => acc + item.calories, 0);
    const count = filteredItems.length;
    return count > 0 ? totalCalories / count : 0;
}


document.querySelector('button').addEventListener('click', function() {
    let color = document.getElementById('color').value;
    let averageCalories = getAverageCaloriesByColor(color);
    console.log(averageCalories);
    console.log(`The average calories for ${color} fruits is ${averageCalories}`);
    document.getElementById("answer").innerHTML=`The average calories for ${color} fruits is ${averageCalories}`;
   
});
