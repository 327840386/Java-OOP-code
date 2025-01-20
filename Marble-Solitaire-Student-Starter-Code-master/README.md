<h2>Marble Solitaire</h2>
<h3>1. About the game</h3>

<p>In this assignment, you will implement a model of a game called &ldquo;Peg Solitaire.&rdquo; This is a board game played by a single player. The game involves moving pegs on a game board with holes. Many modern versions use marbles instead of pegs, giving it the name &ldquo;Marble Solitaire.&rdquo; The image above shows a Marble Solitaire board. It is referred to as a Solitaire-type game, and is also called Brainvita in some countries. If you have not played this game before, <span><a href="https://www.webgamesonline.com/peg-solitaire/">try it here!</a></span></p>
<p>&nbsp;</p>
<h4>1.1. Game Play</h4>
<p>The game starts by arranging marbles on the board. Exactly one slot is empty, and is traditionally the center slot.</p>
<p>A move is made by making one marble jump over exactly one marble and land in an empty slot exactly two positions away. When such a move is made, the marble that is jumped over is removed. Therefore, each single valid move increases the number of empty slots by one. A marble can only jump horizontally or vertically. The game ends when no more valid moves can be made. At any point in the game, the score is the number of marbles on the board. The objective of the game is to make moves so as to end up with the minimum score when the game ends.</p>
<p>In this assignment you will write the model for this game. The model will maintain the state of the game and allow a client to specify moves. You are&nbsp;<em>not</em>&nbsp;required to make the game playable (you are just building the model).</p>
<p>&nbsp;</p>
<h3>2. Building Marble Solitaire</h3>
<h4>2.1. Expected operations</h4>
<p>In order to play the game, the client would expect the following operations: start a new game, make a move, get the current state of the game, get the current score and know when the game has ended. These operations have been specified and documented in the provided&nbsp;<span style="font-family: 'courier new', courier,serif;">MarbleSolitaireModel</span>&nbsp;interface. You are&nbsp;<strong>not</strong>&nbsp;allowed to change the interface in any way!</p>
<p>A short explanation of the methods in the interface follows:</p>
<ul>
    <li><span style="font-family: 'courier new', courier,serif;">move(int fromRow, int fromColumn, int toRow, int toColumn)</span> is called to make a move according to the rules of the game. Specifically it will move a marble from the position <span style="font-family: 'courier new', courier,serif;">(fromRow, fromColumn)</span> to the position <span style="font-family: 'courier new', courier,serif;">(toRow, toColumn)</span> if the move is valid. It will throw an <span style="font-family: 'courier new', courier,serif;">IllegalArgumentException</span> if the move cannot be made.</li>
</ul>
<p>See below for implementation-specific details of how to refer to positions on the board.</p>
<ul>
    <li><span style="font-family: 'courier new', courier,serif;">String getGameState() </span>returns the current state of the game as a&nbsp;<span style="font-family: 'courier new', courier,serif;">String.</span> The exact format of this string is dependent on the implementation (see below).</li>
    <li><span style="font-family: 'courier new', courier,serif;">isGameOver</span> returns<span style="font-family: 'courier new', courier,serif;"> true</span> if the game is over, and <span style="font-family: 'courier new', courier,serif;">false <span style="font-family: lato, 'Helvetica Neue', Helvetica, Arial, sans-serif;">if the game is not over.</span></span></li>
    <li><span style="font-family: 'courier new', courier,serif;">int getScore() </span>returns the current score in the game (i.e., the number of marbles on the board).</li>
</ul>
<p>&nbsp;</p>
<h4>2.2. Unit tests</h4>
<p>You must check that your<span>&nbsp;</span><span class="RktBlk" style="font-family: 'courier new', courier,serif;"><span class="JavaHighlight"><span class="ProfjType">MarbleSolitaireModelImpl</span></span></span><span>&nbsp;</span>implementation of the<span>&nbsp;</span><span class="RktBlk" style="font-family: 'courier new', courier,serif;"><span class="JavaHighlight"><span class="ProfjType">MarbleSolitaireModel</span></span></span><span>&nbsp;</span>interface works as specified. <span style="text-decoration: underline;">We recommend that you create an empty implementation, and then proceed to write your tests</span>. This will allow you to understand how your class will be used, which will help you to implement it.&nbsp;</p>
<p>We will no longer offer unit tests in our auto-grader. Instead, you need to prove that you have written a comprehensive set of tests. The best way to show this to us is by <span style="text-decoration: underline;">running your tests with coverage</span>.</p>
<p>&nbsp;</p>

<h4>2.3. Your Implementation</h4>
<p>Implement the<span>&nbsp;</span><span class="RktBlk" style="font-family: 'courier new', courier,serif;"><span class="JavaHighlight"><span class="ProfjType">MarbleSolitaireModel</span></span></span><span>&nbsp;</span>interface in a class called<span>&nbsp;</span><span class="RktBlk" style="font-family: 'courier new', courier,serif;"><span class="JavaHighlight"><span class="ProfjType">MarbleSolitaireModelImpl</span></span></span>:</p>
<ol>
    <li>
        <p>Design a suitable representation of this game. Think carefully about what fields and types you will need, and how possible values of the fields correspond to game states.</p>
    </li>
    <li>
        <p>Although the traditional game is as shown above, we can generalize the dimensions of this board while retaining its shape. We define the<span>&nbsp;</span><span>arm thickness</span><span>&nbsp;</span>as the number of marbles in the top row (or bottom row, or left or right columns). In the traditional game, the arm thickness is 3, making the length of the largest row/column 7.<span>&nbsp;</span><span>In general, a board of arm thickness&nbsp;<em>a</em>&nbsp;is a board with a single square of size&nbsp;<em>a</em>, with 4 squares of the same size joined at its four sides to form a plus shape.</span><span>&nbsp;</span>In order to keep the &ldquo;centre&rdquo; unique, the arm thickness must be an odd number to be valid. The board scales while keeping the four arms of the plus shape the same size.</p>
    </li>
    <li>
        <p>Positioning: A position is specified using a pair<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjIdentifier">row</span><span class="ProfjDefault">,</span> <span class="ProfjIdentifier">column</span><span class="ProfjKeyword">)</span></span></span>, assuming that the board is laid on a rectangular grid. The row and column numbers start at 0 in the top-left corner, increasing top to bottom and left to right respectively. For example in the above picture, the positions of the three marbles in the top row are<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjLiteral">0</span><span class="ProfjDefault">,</span> <span class="ProfjLiteral">2</span><span class="ProfjKeyword">)</span></span></span>,<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjLiteral">0</span><span class="ProfjDefault">,</span> <span class="ProfjLiteral">3</span><span class="ProfjKeyword">)</span></span></span><span>&nbsp;</span>and<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjLiteral">0</span><span class="ProfjDefault">,</span> <span class="ProfjLiteral">4</span><span class="ProfjKeyword">)</span></span></span><span>&nbsp;</span>respectively. The empty slot is at<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjLiteral">3</span><span class="ProfjDefault">,</span> <span class="ProfjLiteral">3</span><span class="ProfjKeyword">)</span></span></span>.</p>
    </li>
    <li>
        <p><span>Instantiating the game:</span><span>&nbsp;</span>Your class should support<span>&nbsp;</span><span>four</span><span>&nbsp;</span>ways to instantiate it:</p>
        <ul>
            <li>
                <p>The first constructor should take no parameters, and initialize the game board as shown above (arm thickness 3 with the empty slot at the center).</p>
            </li>
            <li>
                <p>A second constructor should take two parameters:<span>&nbsp;<em>empty</em></span><em><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjIdentifier">Row</span></span></span></em><span>&nbsp;</span>and<span>&nbsp;<em>empty</em></span><em><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjIdentifier">Column</span></span></span></em>. It should initialize the game board so that the arm thickness is 3 and the empty slot is at the position<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(<em>empty<span class="ProfjIdentifier">Row</span></em></span><span class="ProfjDefault">,</span> <em>empty<span class="ProfjIdentifier">Column</span></em><span class="ProfjKeyword">)</span></span></span>. If this specified position is invalid, it should throw an<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjType">IllegalArgumentException</span></span></span><span>&nbsp;</span>with a message<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjString">"Invalid empty cell position (<em>r</em>, <em>c</em>)"</span></span></span><span>&nbsp;</span>with <em>r</em> and <em>c</em> replaced with the row and column passed to it.</p>
            </li>
            <li>
                <p>The third constructor should take the arm thickness as its only parameter and initialize a game board with the empty slot at the center. It should throw an<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjType">IllegalArgumentException</span></span></span><span>&nbsp;</span>if the arm thickness is not a positive odd number.</p>
            </li>
            <li>
                <p>Finally a fourth constructor should take the arm thickness, row and column of the empty slot in that order. It should throw an<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjType">IllegalArgumentException</span></span></span><span>&nbsp;</span>if the arm thickness is not a positive odd number, or the empty cell position is invalid.</p>
            </li>
        </ul>
        <p>Carefully think about the shape of the board and our positioning scheme to infer which positions are invalid. <span style="text-decoration: underline;">Make sure you avoid code duplication (this includes your four constructors).</span></p>
    </li>
    <li>
        <p><span>The game state:</span><span>&nbsp;</span>The<span>&nbsp;</span><span class="RktBlk" style="font-family: 'courier new', courier,serif;"><span class="JavaHighlight"><span class="ProfjIdentifier">getGameState</span></span></span><span>&nbsp;</span>method may be used to print the game state in the format illustrated below. Specifically each slot should be one character (<span class="RktBlk"><span class="JavaHighlight"><span class="ProfjLiteral">' '</span></span></span>,<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjLiteral">'O'</span></span></span><span>&nbsp;</span>or<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjLiteral">'_'</span></span></span>) and there should be one space between the positions. There should be no spaces after the last slot in a row. The following shows the output corresponding to the screenshot above:</p>
        <p>&nbsp;</p>
        <pre> &nbsp; &nbsp;O O O &nbsp; &nbsp;<br /> &nbsp; &nbsp;O O O &nbsp; &nbsp;<br />O O O O O O O<br />O O O _ O O O<br />O O O O O O O<br /> &nbsp; &nbsp;O O O &nbsp; &nbsp;<br /> &nbsp; &nbsp;O O O &nbsp; &nbsp;</pre>
        <p>&nbsp;</p>
    </li>
    <li>
        <p><span>Move:</span><span>&nbsp;</span>The<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjIdentifier">move</span></span></span><span>&nbsp;</span>method should make the move and change the game state appropriately. A move is valid if all these conditions are true: (a) the &ldquo;from&rdquo; and &ldquo;to&rdquo; positions are valid (b) there is a marble at the specified &ldquo;from&rdquo; position (c) the &ldquo;to&rdquo; position is empty (d) the &ldquo;to&rdquo; and &ldquo;from&rdquo; positions are exactly two positions away (horizontally or vertically) (e) there is a marble in the slot between the &ldquo;to&rdquo; and &ldquo;from&rdquo; positions. Any invalid move should result in an<span>&nbsp;</span><span class="RktBlk" style="font-family: 'courier new', courier,serif;"><span class="JavaHighlight"><span class="ProfjType">IllegalArgumentException</span></span></span><span>&nbsp;</span>exception with an appropriate message on a single line. The text of the message is up to you.</p>
        <p>For example, the only valid moves on the board shown above start from<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjLiteral">5</span><span class="ProfjDefault">,</span> <span class="ProfjLiteral">3</span><span class="ProfjKeyword">)</span></span></span>,<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjLiteral">1</span><span class="ProfjDefault">,</span> <span class="ProfjLiteral">3</span><span class="ProfjKeyword">)</span></span></span>,<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjLiteral">3</span><span class="ProfjDefault">,</span> <span class="ProfjLiteral">1</span><span class="ProfjKeyword">)</span></span></span><span>&nbsp;</span>or<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjLiteral">3</span><span class="ProfjDefault">,</span> <span class="ProfjLiteral">5</span><span class="ProfjKeyword">)</span></span></span>, and all move to<span>&nbsp;</span><span class="RktBlk"><span class="JavaHighlight"><span class="ProfjKeyword">(</span><span class="ProfjLiteral">3</span><span class="ProfjDefault">,</span> <span class="ProfjLiteral">3</span><span class="ProfjKeyword">)</span></span></span>.</p>
    </li>
</ol>
<p>Be sure to properly document your code with <em>Javadoc</em> as appropriate. Method implementations that inherit <em>Javadoc</em> need not provide their own unless they implement something different or in addition to what is specified in the inherited documentation.</p>
<p>&nbsp;</p>
<h3>3. List of Deliverables</h3>
<ul>
    <li>
        <p><em>/src</em> directory:</p>
        <ul>
            <li>
                <p>The interface (<span class="RktSym" style="font-family: 'courier new', courier,serif;">MarbleSolitaireModel.java</span>)</p>
            </li>
            <li>
                <p>Implementation of the interface(<span class="RktSym" style="font-family: 'courier new', courier,serif;">MarbleSolitaireModelImpl.java</span>)</p>
            </li>
            <li>
                <p>Any additional classes you saw fit to write</p>
            </li>
        </ul>
    </li>
    <li><em>/test</em> directory:
        <ul>
            <li>
                <p>Tests in one or more JUnit test classes</p>
            </li>
        </ul>
    </li>
    <li><em>/res</em> directory:
        <ul>
            <li>A screenshot of your IDE showing the output of running the unit tests with coverage (see example above)</li>
        </ul>
    </li>
</ul>
<p><span>Please ensure all of your project&rsquo;s&nbsp;source&nbsp;is in the&nbsp;<span class="RktBlk" style="font-family: 'courier new', courier,serif;"><span class="JavaHighlight"><span class="ProfjIdentifier">solitaire</span></span></span>&nbsp;package. Place your tests in the default package.</span></p>
<p>&nbsp;</p>
<h3>4. Grading Standards</h3>
<div class="SIntrapara">For this assignment, you will be graded on</div>
<div class="SIntrapara">
    <ul>
        <li>
            <p>whether your code implements the specification (functional correctness)</p>
        </li>
        <li>
            <p>the appropriateness of your chosen representation</p>
        </li>
        <li>
            <p>the clarity of your code</p>
        </li>
        <li>
            <p>the comprehensiveness of your test coverage</p>
        </li>
        <li>
            <p>how well you have documented your code</p>
        </li>
        <li>
            <p>how well you follow the<span>&nbsp;</span>style guide (<em>Checkstyle</em>).</p>
        </li>
    </ul>
</div>
<p>&nbsp;</p>