include <iostream>
using namespace std;
int main() {
    int sum = 0;
    int max_sum = -99999;
    int arr[6][6];
    for(int i=0;i<=5;i++){
        for(int j=0;j<=5;j++){
            cin>>arr[i][j];
        }
    }
    
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            for(int k=i;k<i+3;k++){
                for(int m=j;m<j+3;m++){
                    
                    if(k == i+1 && m != j+1){
                       //sum += arr[k][m+1];
                    }
                    else{
                        sum += arr[k][m];
                    }
                }
                
            }
            
            if(sum > max_sum){
                max_sum = sum;
            }
            sum = 0;
            
        }
        
    }
    cout<<max_sum;
    return 0;
}