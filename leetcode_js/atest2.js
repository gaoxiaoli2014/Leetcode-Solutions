/**
 * @param {number[][]} buildings
 * @return {number[][]}
 */
  /**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    var heap = [];
    for(var i = 0; i < nums.length; i++){
        heappush(heap,nums[i]);
    }
    for(i = 0; i < k-1; i++){
        heappop(heap);
    }
    return heap[0];
};

function heappush(arr, obj){
    arr.push(obj);
    var i = arr.length-1;
    while(i>0){
        var p = Math.floor((i-1)/2);
        if(arr[i] > arr[p]){ 
            var tmp = arr[i];
            arr[i] = arr[p];
            arr[p] = tmp;
            i = p;
        }else{
            break;
        }
    }
}
 
function heappop(arr){ 
    if(arr.length == 1){
        arr.pop();
        return;
    }
    arr[0] = arr.pop();
    var i = 0;
    while(2*i+1 < arr.length){
        if(2*i+2 >= arr.length){
            if(arr[i] < arr[2*i+1]){
                var tmp = arr[i];
                arr[i] = arr[2*i+1];
                arr[2*i+1] = tmp; 
                i = 2*i + 1;
            }
            return;
        }

        if(arr[2*i+1]>arr[2*i+2]){
            if(arr[i] < arr[2*i+1]){
                var tmp = arr[i];
                arr[i] = arr[2*i+1];
                arr[2*i+1] = tmp; 
                i = 2*i + 1;
            }
            else if(arr[i] < arr[2*i+2]){
                var tmp = arr[i];
                arr[i] = arr[2*i+2];
                arr[2*i+2] = tmp;
                i = 2*i +2;
            } else{break;}
        }else{
            if(arr[i] < arr[2*i+2]){
                var tmp = arr[i];
                arr[i] = arr[2*i+2];
                arr[2*i+2] = tmp; 
                i = 2*i + 2;
            }
            else if(arr[i] < arr[2*i+1]){
                var tmp = arr[i];
                arr[i] = arr[2*i+1];
                arr[2*i+1] = tmp;
                i = 2*i +1;
            } else{break;}
        }
    }
}


console.log("test")
 
console.log(findKthLargest([2,1],2));
console.log("[[2,70],[4,30],[6,41],[7,70],[10,102],[30,41],[60,91],[80,72],[90,59],[120,0]]");