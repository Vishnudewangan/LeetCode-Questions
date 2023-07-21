In the case LLRR : there will be no collisions since two cars are moving towards Left and two cars moving towards right
<- <- -> ->
L  L  R  R
​
In the case RRRRLL :
->  ->  -> ->  <- <-
R    R   R  R  L  L
0    1   2  3  4  5
​
Cars 3 and 4 collide and become stationary (S), since cars 0, 1, 2 are moving towards this stationary car so they will all
collide and cars 4 and 5 are moving towards the same stationary card from the left direction so even they will collide and
become stationary (S). We will store cars 0,1,2, 3 in stack and when current car is driving towards left we pop 3 and change
the current car’s state to stationary and pop rest of the cars driving towards it from the right direction and calculate the
collision value.
​
In the case RSLRL:
​
-> |  <-  -> <-
R  S  L    R  L
0  1  2    3  4
​
Car 0 collides with the stationary car 1, car 2 collides with the stationary car 1 and cars 3 and 4 collide with each other.