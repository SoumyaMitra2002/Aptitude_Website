<%@page import="com.tech.blog.entities.Count" %>
<%@page import="com.tech.blog.entities.QuestionTake" %>
<%@page import="com.tech.blog.entities.Message" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Question</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .banner-background {
                clip-path: circle(50% at 50% 50%);
                /*clip-path: polygon(50% 0%, 80% 10%, 100% 35%, 100% 70%, 80% 90%, 50% 100%, 20% 90%, 0% 70%, 0% 35%, 20% 10%);*/
                /*clip-path: polygon(30% 0%, 90% 0%, 100% 0, 100% 100%, 73% 100%, 30% 96%, 0 100%, 0 0);*/
            }

            .div1 {
                display: flex;
                flex-direction: row;

            }

            @keyframes fadeOut {
                0% {
                    opacity: 1;
                }

                100% {
                    opacity: 0;
                }
            }

            #myElement {
                animation: fadeOut 2s forwards;
            }

        </style>


    </head>

    <body>

        <main class="d-flex align-items-center banner-background primary-background "
              style="height: 100vh; width:90vw ">
            <div class="container">
                <div class="col-md-4 offset-md-4">
                    <div class="card">

                        <div class="card-body">
                            <form action="QuestionServlet" method="post">
                                <%
                                    Count b = (Count) session.getAttribute("cc");
                                    Message m = (Message) session.getAttribute("msg");
                                    if (m != null) {
                                %>
                                <div class="alert" role="alert">

                                    <div style="color: green; font-size: 20px;" id="myElement">
                                        <%= m.getContent()%>
                                        <%= b.getCount()%>
                                    </div>
                                </div>
                                <div class="alert alert-primary" role="alert">
                                    <p style="font-size: 20px;"> Question No. <%= b.getCount()%>  </p> 
                                </div>
                                <%
                                        session.removeAttribute("msg");
                                        session.removeAttribute("cc");
                                    }
                                %>


                                

                                <div class="form-group">
                                    <label for="exampleInputEmail1">Enter the question</label>
                                    <input name="question" required type="text" class="form-control"
                                           id="exampleInputEmail1" aria-describedby="emailHelp"
                                           placeholder="Enter Question">

                                </div>
                                <br>
                                <div class="div1 ">
                                    <h5>A</h5>
                                    <input type="text" name="a" placeholder="Please add option"
                                           required  class="form-control" style=" margin-left:10px;">
                                </div>
                                <br>
                                <div class="div1">
                                    <h5>B</h5>
                                    <input type="text" name="b" placeholder="Please add option" required
                                           class="form-control" style=" margin-left:10px;">
                                </div>
                                <br>
                                <div class="div1">
                                    <h5>C</h5>
                                    <input type="text" name="c" placeholder="Please add option"
                                           required class="form-control" style=" margin-left:10px;">
                                </div>
                                <br>
                                <div class="div1">
                                    <h5>D</h5>
                                    <input type="text" name="d" placeholder="Please add option"
                                           required class="form-control" style=" margin-left:10px;">
                                </div>

                                <br>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">Answer</label>
                                    <input name="answer" required type="text" class="form-control"
                                           id="exampleInputEmail1" aria-describedby="emailHelp"
                                           placeholder="Enter Answer">
                                </div>

                                <div class="container text-center">
                                    <button type="submit" class="btn btn-primary">Add</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </main>
        <script>
            setTimeout(function () {
                var element = document.getElementById("myElement");
                element.style.display = "none";
            }, 2000);

        </script>




    </body>

</html>