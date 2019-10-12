#include<bits/stdc++.h>
using namespace std;

int solve (vector<vector<int> > A) {
   // Write your code here
   int max_element = 0;
   int curr_half = 0;
   int left_sum = 0;
   int right_sum = 0;
   int result = 0;
   
   for(int j=0;j<A[0].size()/2;j++){
       if(A[0][j] > max_element){
           max_element = A[0][j];
           curr_half = 0;
       }
   }
   
   for(int k=A.size()/2;k<A[0].size();k++){
       if(A[0][k] > max_element){
           max_element = A[0][k];
           curr_half = 1;
       }       
   }   
   
   result = max_element;
   
   for(int i=1;i<A.size();i++)
   {
       max_element = 0;
       if(curr_half == 1){
           for(int j=0;j<A[i].size()/2;j++){
               if(A[i][j] > max_element){
                  max_element = A[i][j]; 
               }
           }  
           curr_half = 0;
       }else{
           for(int k=A.size()/2;k<A[i].size();k++){
               if(A[i][k] > max_element){
                    max_element = A[i][k]; 
               }
           }  
           curr_half = 1;
       }
       
       result += max_element;
   }
   
   return result;   
}

int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    for(int t_i=0; t_i<T; t_i++)
    {
        int N;
        cin >> N;
        int M;
        cin >> M;
        vector<vector<int> > A(N, vector<int>(M));
        for (int i_A=0; i_A<N; i_A++)
        {
        	for(int j_A=0; j_A<M; j_A++)
        	{
        		cin >> A[i_A][j_A];
        	}
        }

        int out_;
        out_ = solve(A);
        cout << out_;
        cout << "\n";
    }
}