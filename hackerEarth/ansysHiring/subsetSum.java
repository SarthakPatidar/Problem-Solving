#include<bits/stdc++.h>
using namespace std;

bool sumPossible(vector<long long> curr_vec, int size, int sum){
    bool sub[size+1][sum+1];
    for(int i=0;i <= size; i++){
        sub[i][0] = true;
    }
    
    for(int i=1; i<= sum; i++){
        sub[0][i] = false;
    }
    
    for(int i=1;i<=size;i++){
        for(int j=1;j<= sum;j++){
            if(j < curr_vec[i-1])
                sub[i][j] = sub[i-1][j];
            
            if(j >= curr_vec[i-1])
                sub[i][j] = sub[i-1][j] || sub[i-1][j - curr_vec[i-1]];
        }
    }
    
    return sub[size][sum];
}

vector<int> solve (int A0, vector<long long> X, int N, int Q) {
   // Write your code here
   // Return a vector arr of size Q, such that arr[i]=1 if ith query evalutes to true otherwise 0.
   vector<int> result;
   vector<long long> curr_vec;
   
   curr_vec.push_back(A0);
   
   for(int i=1; i < N;i++){
       if(i % 2 != 0){
           curr_vec.push_back(3*curr_vec[i-1]+1);
       }else{
          curr_vec.push_back(2*curr_vec[i-1] + 3*curr_vec[i-2]); 
       }
   }
   
   for(int i=0;i<X.size();i++){
       if(sumPossible(curr_vec,curr_vec.size(),X[i]) == true)
            result.push_back(1);
       else 
            result.push_back(0);
   }
   
   return result;
}

int main() 
{   ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    for(int t_i=0; t_i<T; t_i++)
    {   int N;
        cin >> N;
        int A0;
        cin >> A0;
        int Q;
        cin >> Q;
        vector<long long> X(Q);
        for(int i_X=0; i_X<Q; i_X++)
        {
        	cin >> X[i_X];
        }
        
        vector<int> ans = solve(A0, X, N, Q);
        for(int i=0;i<ans.size();i++)
        {  if(ans[i]) cout<<"true"<<endl ; 
           else cout<<"false"<<endl ;     
        }
        
    }
}