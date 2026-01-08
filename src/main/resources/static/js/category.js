
    function updateCategory() {
    const parentCategory=document.getElementById("parentCategory")
    if (!parentCategory || parentCategory === "") return;
    fetch(`/product/childCategoryOption?parentCategory=${parentCategory.value}`)
    .then(resp => resp.json())
    .then(data => {
    let opt = "";
    const childCategory = document.getElementById("childCategory");
    data.forEach(i => {
    const selectedChildOpt=window.selectedChildOpt
    const selectedOpt=(selectedChildOpt==i.childCategoryName)?'selected':''
    opt += `<option value='${i.childCategoryName}' ${selectedOpt} >${i.childCategoryName}</option>`
})
    childCategory.innerHTML = opt
    updateSubCategory();
})
}

    function updateSubCategory(){
    const childCategory=document.getElementById("childCategory");
    if(!childCategory || childCategory==="") return
    fetch(`/product/subCategoryOption?childCategory=${childCategory.value}`)
    .then(resp=>resp.json())
    .then(data=>{
    let opt="";
    console.log(data)
    data.forEach(i=>{
    const selectedsubOpt=window.selectedsubOpt
    const selectedOpt2=(selectedsubOpt==i.subCategoryName)?'selected':''
    opt+=`<option value="${i.subCategoryName}" ${selectedOpt2}>${i.subCategoryName}</option>`
})
    subCategory.innerHTML=opt;
})
}

    if(parentCategory){
    updateCategory();
    parentCategory.addEventListener("change",updateCategory)
}
    if(childCategory){
    childCategory.addEventListener("change",updateSubCategory)
}
