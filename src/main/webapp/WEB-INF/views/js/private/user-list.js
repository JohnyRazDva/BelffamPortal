function ajaxGet(){

            $.getJSON('/user', function (json) {
                console.log(json);
                console.log(json.length)

                var tr = [];
                for (var i = 0; i < json.length; i++) {


                    tr.push('<tr class="user-table-list-data">')
                    tr.push('<th><a href="/options/ui/user/read/'+json[i].id +'">' + json[i].id + '</a></th>');
                    tr.push('<th>' + json[i].firstName + '</th>');
                    tr.push('<th>' + json[i].lastName + '</th>');
                    tr.push('<th>' + json[i].email + '</th>');
                    tr.push('<th>' + json[i].username + '</th>');
                    tr.push('</tr>')


                }
                $('#user_table').append($(tr.join('')));

            });
}
$(document).ready(function(){
            ajaxGet();
        });