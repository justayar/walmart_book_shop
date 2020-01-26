var openedPageNum = 1;

function openDetail(itemId){

    window.location.href = "http://localhost:8080/bookDetails/"+itemId;
}

function openAnotherPage(pageNum,numberOfPages){

     var paginationElements = document.getElementsByClassName("page-numbers");

     removeUnderlineFromPrevOpenedPageInPagination(paginationElements,openedPageNum);

     var pages = document.getElementsByClassName("book_list_single_line_items");

     makeAllPageDivsToNoDisplay(pages);

     openedPageNum = pageNum;

     makeVisibleToOpenedPage(pages,openedPageNum);

     addUnderlineToOpenedPageInPagination(paginationElements,openedPageNum);

     setVisibilityOfPrevButton(openedPageNum);

     setVisibilityOfNextButton(openedPageNum,numberOfPages);

}

function setVisibilityOfPrevButton(nextOpenedPageNum){
     var firstPageNum = 1;

     if(nextOpenedPageNum == firstPageNum){
        hidePrevButton();
     }else{
        showPrevButton();
     }

}


function hidePrevButton(){
     var prevButton = document.getElementsByClassName("prev");
     prevButton[0].style.visibility = 'hidden';
}


function showPrevButton(){
     var prevButton = document.getElementsByClassName("prev");
     prevButton[0].style.visibility = 'visible';
}

function setVisibilityOfNextButton(nextOpenedPageNum,numberOfPages){

     if(nextOpenedPageNum == numberOfPages){
        hideNextButton();
     }else{
        showNextButton();
     }

}


function hideNextButton(){
     var prevButton = document.getElementsByClassName("next");
     prevButton[0].style.visibility = 'hidden';
}


function showNextButton(){
     var prevButton = document.getElementsByClassName("next");
     prevButton[0].style.visibility = 'visible';
}

function makeAllPageDivsToNoDisplay(pages){

    for(var i=0;i<pages.length;i++){
        pages[i].style.display = "none";
    }

}

function makeVisibleToOpenedPage(pages,nextOpenedPageNum){

      var nextOpenedPageNumIndex = nextOpenedPageNum -1;
      pages[nextOpenedPageNumIndex].style.display = "block";
}

function goToNextPage(numberOfPages){

    var pages = document.getElementsByClassName("book_list_single_line_items");

    var paginationElements = document.getElementsByClassName("page-numbers");

    removeUnderlineFromPrevOpenedPageInPagination(paginationElements,openedPageNum);

    makeAllPageDivsToNoDisplay(pages);

    openedPageNum +=1;

    var openedPageNumIndex = openedPageNum-1;

    if(pages.length == openedPageNumIndex){
        //todo call to nextpage to get new pages
    }else{

        addUnderlineToOpenedPageInPagination(paginationElements,openedPageNum)

        makeVisibleToOpenedPage(pages,openedPageNum);

        setVisibilityOfPrevButton(openedPageNum);

        setVisibilityOfNextButton(openedPageNum,numberOfPages);
    }

}

function goToPreviousPage(numberOfPages){

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

    setVisibilityOfNextButton(openedPageNum,numberOfPages);

}

function removeUnderlineFromPrevOpenedPageInPagination(paginationElements,prevPageNum){

    var prevOpenedPageNumIndex = prevPageNum -1;
    paginationElements[prevOpenedPageNumIndex].style.textDecoration = "none";
}

function addUnderlineToOpenedPageInPagination(paginationElements,nextOpenedPageNum){

    var nextOpenedPageNumIndex = nextOpenedPageNum -1;
    paginationElements[nextOpenedPageNumIndex].style.textDecoration = "underline";

}
