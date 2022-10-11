# recrutation_task

Structure:
* rummer - main method of application
* hedgehogproblem - solver of the HEdgehog Problem
* io - classes to read from and write to files

Exceptions: 
There is thrown IncorrectMatrixException when provided matrix is emty or isn't matrix

Hedgehog Porblem sollution for matrix (MxN):
* time cost - O(N*M)
* additional memory cost: O(min(M, N))

Algorithm:
For given matrix NxM (lets assume that N < M), program creates additiona array of N elements.
Algoritm iterates over rows and then over each field in row.
For each field algoritm executes two operations:
1) It adds to stored value in temporary table at the same index as field value of this field. 
It represents possible count of apples that hedgehog can collect if it goes to the field of given index in next row from field that is currently used.
2) It check if sum of value in temporary table at the same index as field value of this field and value of this field is greater than value of next field in temporary table.
It represents validation if going to the next field using path from current field will be better for hedgehog than going from previous row.

 

