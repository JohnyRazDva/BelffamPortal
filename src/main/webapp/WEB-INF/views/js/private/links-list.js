function ajaxGet(){

            $.getJSON('/link', function (json) {


                var tr = [];
                for (var i = 0; i < json.length; i++) {
                    /*<a th:href="@{${link.linkValue}}" th:text="${link.description}" class="doc-links" target="_blank"></a>*/

                    tr.push('<div class="documents-link-box">')
                    tr.push('<a href="'+ json[i].linkValue +'" class="doc-links" target="_blank">'+ json[i].description +'</a>')
                    tr.push('<div class="editLinkForm">')
                    tr.push('<form  method="POST"  id="editLinkForm" action="/private/documents/update/'+json[i].id+'">')
                    tr.push('<input type="text" name="linkValue" value="'+ json[i].linkValue +'"></input>')
                    tr.push('<input type="text" name="description" value="'+ json[i].description +'"></input>')
                    tr.push('<button type="submit" class="update-user-data-form-button">save</button>')
                    tr.push('</form>')
                    tr.push('<form method="GET" action="/private/documents/delete/'+json[i].id+'">')
                    tr.push('<button type="submit" class="update-user-data-form-button">delete</button>')
                    tr.push('</form>')
                    tr.push('</div>')

                    tr.push('</div>')
                }
                $('#link_list').append($(tr.join('')));

            });
}

$(document).ready(function(){
            ajaxGet();
        });

function button_onclick(element) {
    var visibility = element.style.visibility;
    element.style.visibility = visibility == "visible" ? 'hidden' : "visible";
}

function toggleBoxVisibility(){
    var forms = document.getElementsByClassName("editLinkForm");
    for(i=0; i<forms.length; i++){
        if(document.getElementById("edit_links_checkbox").checked == true){
            forms[i].style.visibility = "visible";
        }else{
            forms[i].style.visibility = "hidden";
        }
    }
}



