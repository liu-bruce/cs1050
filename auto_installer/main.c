#include <stdlib.h>
#include <stdio.h>
#include "functions.h"

void main()
{
  // full update
  system("conda update --all -y");
  // java install
  system("conda install -c cyclus java-jdk -y");
  //gcc install
  system("conda install -c conda-forge m2w64-gcc -y");
  //git instakk
  system("conda install -c anaconda git -y ");
  // atom text editor
  system("conda install -c conda-forge atom -y");

}
