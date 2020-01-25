var openedPageNum = 1;

function openDetail(itemId){

    window.location.href = "http://localhost:8080/bookDetails/"+itemId;
}

function openAnotherPage(pageNum,nextPage){

     var paginationElements = document.getElementsByClassName("page-numbers");

     removeUnderlineFromPrevOpenedPageInPagination(paginationElements,openedPageNum);

     var pages = document.getElementsByClassName("book_list_single_line_items");

     makeAllPageDivsToNoDisplay(pages);

     openedPageNum = pageNum;

     makeVisibleToOpenedPage(pages,openedPageNum);

     addUnderlineToOpenedPageInPagination(paginationElements,openedPageNum);

     setVisibilityOfPrevButton(openedPageNum);

}

function setVisibilityOfPrevButton(openedPageNum){
     var firstPageNum = 1;

     if(openedPageNum == 1){
        hidePrevButton();
     }else{
        showPrevButton();
     }

}


function hidePrevButton(){
     var prevButton = document.getElementsByClassName("prev");
     prevButton[0].style.visibility = 'hidden';
}


function showPrevButton(openedPageNum){
     var prevButton = document.getElementsByClassName("prev");
     prevButton[0].style.visibility = 'visible';
}

function makeAllPageDivsToNoDisplay(pages){

    for(var i=0;i<pages.length;i++){
        pages[i].style.display = "none";
    }

}

function makeVisibleToOpenedPage(pages,openedPageNum){

      var openedPageNumIndex = openedPageNum -1;
      pages[openedPageNumIndex].style.display = "block";
}

function goToNextPage(){

    var pages = document.getElementsByClassName("book_list_single_line_items");

    var paginationElements = document.getElementsByClassName("page-numbers");

    removeUnderlineFromPrevOpenedPageInPagination(paginationElements,openedPageNum);

    makeAllPageDivsToNoDisplay(pages);

    openedPageNum +=1;

    if(pages.length == openedPageNum){
        //todo call to nextpage to get new pages
    }else{

        addUnderlineToOpenedPageInPagination(paginationElements,openedPageNum)

        makeVisibleToOpenedPage(pages,openedPageNum);

        setVisibilityOfPrevButton(openedPageNum);
    }

}

function goToPreviousPage(){

    var pages = document.getElementsByClassName("book_list_single_line_items");

    if(openedPageNum == 1){
         return;
    }

    var paginationElements = document.getElementsByClassName("page-numbers");

    removeUnderlineFromPrevOpenedPageInPagination(paginationElements,openedPageNum);

    openedPageNum -=1;

    addUnderlineToOpenedPageInPagination(paginationElements,openedPageNum)

    makeAllPageDivsToNoDisplay(pages);

    makeVisibleToOpenedPage(pages,openedPageNum);

    setVisibilityOfPrevButton(openedPageNum);

}

function removeUnderlineFromPrevOpenedPageInPagination(paginationElements,prevPageNum){

    var prevOpenedPageNumIndex = prevPageNum -1;
    paginationElements[prevOpenedPageNumIndex].style.textDecoration = "none";
}

function addUnderlineToOpenedPageInPagination(paginationElements,openedPageNum){

    var openedPageNumIndex = openedPageNum -1;
    paginationElements[openedPageNumIndex].style.textDecoration = "underline";

}
