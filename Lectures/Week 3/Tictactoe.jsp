<%@ page language="java" import ="java.util.*" import="java.math.*" %>

<html>
<head><title>TicTacToe</title></head>

<body>
<h1>TicTacToe</h1>

<% // Declare and initialize game state variables
  char[][] tiles; // game board
  String winner;  // game winner

  // Initialize state if it is not already present in the session 
  tiles = (char[][]) session.getAttribute("tiles");
  winner = (String) session.getAttribute("winner"); 
  if (tiles == null || winner == null) {
    tiles = new char[3][3];
    for (int r=0; r<3; r++) 
      for (int c=0; c<3; c++) 
        tiles[r][c] = ' ';
    winner = new String("");
  }
%>

<%  // Check for a "Reset" button click
  if (request.getParameter("reset") != null) {
    for (int r=0; r<3; r++) 
      for (int c=0; c<3; c++) 
        tiles[r][c] = ' ';
    winner = new String("");
  }
%>

<%  // Check for a game button click
  boolean didX = false;
  if (winner.equals("")) {
    for (int r=0; r<3; r++) { 
      for (int c=0; c<3; c++) {
        if (request.getParameter("B" + r + c) != null && tiles[r][c] == ' ') {
          tiles[r][c] = 'X';
          didX = true;
        }
      }
    }
  } 
  if (didX) {
    // see if X won
    for (int r=0; r<3; r++) {
      if (tiles[r][0]=='X' && tiles[r][1]=='X' && tiles[r][2] == 'X') {
         winner = new String("X");
      }
    }
    for (int c=0; c<3; c++) {
      if (tiles[0][c]=='X' && tiles[1][c]=='X' && tiles[2][c] == 'X') {
         winner = new String("X");
      }
    }
    if (tiles[0][0]=='X' && tiles[1][1]=='X' && tiles[2][2] == 'X') {
       winner = new String("X");
    }
    if (tiles[0][2]=='X' && tiles[1][1]=='X' && tiles[2][0] == 'X') {
      winner = new String("X");
    }
  }

  // play O
  if (didX && winner.equals("")) {
    boolean playable = false;
    for (int r=0; r<3; r++) for (int c=0; c<3; c++) {
      if (tiles[r][c] == ' ') {
        playable = true;
      }
    }
    if (playable) {
      boolean didO = false;
      while (!didO) {
        int r = (int) (Math.random() * 3);
        int c = (int) (Math.random() * 3);
        if (tiles[r][c] == ' ') {
          tiles[r][c] = 'O';
          didO = true;
        }
      }
      
      // check for "O" win
      for (int r=0; r<3; r++) {
        if (tiles[r][0]=='O' && tiles[r][1]=='O' && tiles[r][2] == 'O') {
           winner = new String("O");
        }
      }
      for (int c=0; c<3; c++) {
        if (tiles[0][c]=='O' && tiles[1][c]=='O' && tiles[2][c] == 'O') {
          winner = new String("O");
        }
      }
      if (tiles[0][0]=='O' && tiles[1][1]=='O' && tiles[2][2] == 'O') {
         winner = new String("O");
      }
      if (tiles[0][2]=='O' && tiles[1][1]=='O' && tiles[2][0] == 'O') {
         winner = new String("O");
      }
    }
  }
%>

<% // Save game state as session attributes
  session.setAttribute("tiles", tiles);
  session.setAttribute("winner", winner);
%>


<form action="tictactoe.jsp" method="post">
 <table border="1" >
 <tbody>
 
 <%  // output the game board
  for (int r=0; r<3; r++) {
    out.println("<tr>");
    for (int c=0; c<3; c++) {
      out.println("<td><input type=\"submit\" name=\"B" + r + c + "\"" +
        " value=\"" + tiles[r][c] + "\"></td>");
    }
    out.println("</tr>");
  }
 %>
 </tbody>
 </table>

 <%  // display winner
  if (!winner.equals("")) {
    out.println("<p>" + winner + " Won!</p>");
  }
 %>

 <p><input type="submit" name="reset" value="Reset"></p>
</form>

</body>
</html>

