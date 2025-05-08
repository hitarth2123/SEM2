const body=document.body
const button=document.querySelector("button")
const section=document.querySelector("section")
console.log(body);
console.log(section);



button.addEventListener("click", ()=>{
    console.log("hello");
    button.innerText="Dark Mode"
    body.classList.toggle("dark")
    section.classList.toggle("dark")
    console.log(Button);
    
})