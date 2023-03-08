# Tic-Tac-Toe (Java)

<div>
Tic-tac-toe is a simple, two-player game that asks the players to fill 3-by-3 grid with 'X' and 'O'.
</div>
<div>
The goal of tic-tac-toe is to be the first player to get three in a row on a 3-by-3 grid.
</div>
<br/>
<div>
Players alternate placing Xs and Os on the board until either player has three in a row, horizontally, vertically, or diagonally or until all squares on the grid are filled. If a player is able to draw three Xs or three Os in a row, then that player wins. If all squares are filled and neither player has made a complete row of Xs or Os, then the game is a draw.
</div>
<br/>
<div>
In this project, the game is created by using Java programming language. It implements the concept of Array, 2D Array, and ArrayList. The array represents the number of tiles or buttons in a tic-tac-toe board, while the 2D array stores the win indexes combinations and array lists store the current Xs and Os indexes. Array lists make the win checking more practical because they provides some helpful methods, such as .add and .contains).
</div>
<br />
<div>
Methods or functions are also created in this project. Some of the methods are:
<ul>
<li>actionPerformed: manage X and O switching turns and set the text in the button that is clicked according to the symbol and turn.</li>
<li>firstTurn: set who start the first round of the game randomly (if the random number is 0, then X will start first. Otherwise, O will open the game).</li>
<li>check: check the winning condition, set the text title based on the winning result("X wins", "O wins", "Tie").</li>
<li>checkWin: check the winning condition in more detail.</li>
<li>tieGame: disable the buttons and set the title to "Tie" if the game is in a tie.</li>
<li>disableButtons: disable buttons when the game has not started or the game has ended.</li>
<li>enableButtons: enable buttons when the game is started.</li>
</ul>
</div>
<br />
<div>
<h2>Test Cases:</h2>
Here are the gameplay examples and conditions that might happen in the Tic-Tac-Toe game:

</div>
