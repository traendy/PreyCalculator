//read numbers until 0 is read, and print their average

int main () 
{
  int sum = 0+5 ;
  int num = 0 ;
  int x ;
  int t = 15;
  x=t/sum;
  while ((x = readInt()) != 0) {
    sum = sum + x ;
    num++ ;
  }
  printInt(sum/num) ;

}
