/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function edit(id){  
    if (confirm("Are you sure you want to edit?") === true) {
        window.location = "./editproduct?id=" + id;
    } else {
        console.log("cancel")
    }
}

