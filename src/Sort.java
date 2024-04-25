import static java.lang.Math.floor;

/**
 * Class Sort bao gồm tất cả các phương thức sắp xếp mà mình được học từ khóa Algorithm and Datastructures
 */
public class Sort {
    public Sort(){}

    //Insertion Sort

    /**
     * Phương thức này nhận vào một array ngẫu nhiên và sắp xếp các phần tử thuộc array đó theo chiều
     * từ trái sang phải bằng cách chọn ra một phần tử "key" và so sánh nó với phần tử nằm bên trái.
     * Nếu như "key" nhỏ hơn phần tử bên trái thì ta hoán đổi vị trí hai phần tử và tiếp tục làm như vậy cho
     * đến khi không còn phần tử nào ở bên trái lớn hơn hoặc không còn phần tử nào để so sánh nữa.
     * Phương thức kết thúc Khi cả array đã được sắp xếp lại theo thứ tự từ nhỏ đến lớn.
     * @param a array cần được sắp xếp lại
     */
    public static void insertionSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j = j - 1;
            }
            a[j+1] = key;
        }
    }

    /**
     * Phương thức này cho ra kết quả như insertionSort, chỉ khác thay vì sử dùng for-loop cho
     * vòng lặp ta sử dụng đệ quy để gọi lại chính phương thức đó.
     * Phương thức kết thúc khi i<=1.
     * @param a array cần được sắp xếp lại
     * @param i số thứ tự của phần tử đang được xét
     */
    public static void RecursiveInsertionSort(int[] a, int i){
        if (i<=1){return;} // Base case
        RecursiveInsertionSort(a,i-1); // Recursively sort first n-1 element
        int key = a[i-1];
        int j = i-2;
        while (j >= 0 && a[j] > key){
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = key;
    }

    /**
     * Phương thức này hoạt động ngược lại so với phương thức insertionSort thông thường,
     * nó sẽ sắp xếp các phần tử theo độ lớn tăng dần theo chiều từ phải sang trái.
     * @param a array cần được sắp xếp lại
     */
    public static void insertionSortReverse(int[] a){
        for (int i = a.length-2; i >= 0; i--) {
            int key = a[i];
            int j = i + 1;
            while (j <= a.length-1 && a[j] > key) {
                a[j-1] = a[j];
                j = j + 1;
            }
            a[j-1] = key;
        }
    }

    /**
     * Phương thức này cho ra kết quả giống với insertionSortReverse, nó thay thế for-loop bằng
     * cách sử dụng đệ quy để gọi lại chính nó.
     * @param a array cần được sắp xếp lại
     * @param i số thứ tự của phần từ đang được xét
     */
    public static void RecursiveInsertionSortReverse(int[] a, int i){
        if (i >= a.length-2){return;}
        RecursiveInsertionSortReverse(a,i+1);
        int key = a[i+1];
        int j = i+2;
        while (j <= a.length-1 && a[j] > key){
            a[j-1] = a[j];
            j++;
        }
        a[j-1] = key;
    }

    /**
     * Phương thức này sắp xếp lại array theo chiều từ trái sang phải với thứ tự tăng dần
     * @param a array cần được sắp xếp lại
     */
    public static void bubbleSort(int[] a){
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * Phương thức sử dụng phương pháp đệ quy để chia nhỏ array được xét ra thành nhiều array nhỏ và tiếp tục
     * làm như vậy cho đến khi array đủ nhỏ để có thể bắt đầu được so sánh . Các array nhỏ sau sắp xếp sẽ được
     * gắn lại thành array lớn nhờ phương thức hỗ trợ merge.
     * @param A array được xét
     * @param l số thứ tự của phần tử bên trái ngoài cùng thuộc array
     * @param r số thứ tự của phần tử bên phải ngoài cùng thuộc array
     * @throws Exception nếu không đạt được điều kiện
     */
    public static void mergeSort(int[] A, int l, int r) throws Exception{
        int m = 0;
        if (l < r) { // more than one element
            m = (int) floor((double) (l + r) / 2);
            mergeSort(A, l, m);
            mergeSort(A, m + 1, r);
            merge(A, l, m, r);
        }
    }

    /**
     * Phương thức sẽ phân tích hai nửa của array từ vị trí của m. Bắt đầu xét từ phần tử bên trái ngoài cùng của
     * mỗi bên, phần tử nhỏ hơn sẽ được lưu vào một array tạm thời B và cứ tiếp tục như vậy cho đến khi hai phân nửa
     * đã được phân loại theo chiều từ nhỏ đến lớn và được lưu lại vào array B.
     * Bây giờ ta trả các giá trị của B sang về array được xét ban đầu theo đúng thứ tự.
     * @param A array được xét
     * @param l số thứ tự của phần tử bên trái ngoài cùng thuộc array
     * @param m số thứ tự của phần tử nằm giữa array, được làm tròn xuống nếu không phải số nguyên tố
     * @param r số thứ tự của phần tử nằm phải ngoài cùng thuộc array
     * @throws Exception nếu không đáp ứng được điều kiện
     */
    private static void merge(int [] A, int l, int m, int r) throws Exception{
        if (l>m || m>r) {throw new Exception("not fulfill the requirement");}
        int[] B = new int[r-l+1];
        int pl = l;
        int pr = m+1;
        for (int i = 0; i <= r-l; i++) {
            if (pr > r || (pl <= m && A[pl] <= A[pr])) {
                B[i] = A[pl];
                pl = pl+1;
            } else {
                B[i] = A[pr];
                pr = pr+1;
            }
        }
        for (int i = 0; i <= r-l; i++) {
            A[i+l] = B[i];
        }
    }

    /**
     * Về cơ chế phương thức hoạt động giống mergeSort, chỉ khác là thay vì chia array ra làm đôi,
     * phương thức chọn ra một phần tử làm trung gian nhằm so sánh các phần tử còn lại dựa trên phần
     * tử đó. Việc chọn phần tử sẽ do phương thức hỗ trợ partition quyết định.
     * @param A array được xét
     * @param l số thứ tự của phần tử bên trái ngoài cùng thuộc array
     * @param r số thứ tự của phần tử bên phải ngoài cùng thuộc array
     */
    public static void quicksort(int[] A, int l, int r){ //initial call: L=0; r=A.length-1
        int p;
        if (l<r){
            p = partition(A,l,r);
            quicksort(A,l,p);
            quicksort(A,p+1,r);
        }
    }

    /**
     * Phương thức chọn ra phần tử pivot dựa trên giá trị l được gọi. Sau đó phương thức chạy từ trái sang phải
     * cho đến khi tìm được phần tử thứ nhất lớn hơn pivot, sau đó tiếp tục chạy từ phải sang trái đến khi tìm
     * được phần tử thứ hai nhỏ hơn pivot. Sau đó ta hoán đổ vị trí của hai phần tử đó nếu phần tử thứ nhất nhỏ
     * hơn phần tử thứ hai. Còn nếu không ta sẽ trả về số thứ tự của phần tử thứ hai.
     * @param A array được xét
     * @param l số thứ tự của phần tử bên trái ngoài cùng thuộc array
     * @param r số thứ tự của phần tử bên phải ngoài cùng thuộc array
     * @return trả lại phần tử trung gian p
     */
    private static int partition(int[] A, int l, int r){ //requires l<r, returns int in l...r-1
        int pivot = A[l];
        int pl = l-1;
        int pr = r+1;
        while (pl<pr){
            do{pl=pl+1;}while(A[pl]<pivot);
            do{pr=pr-1;}while(A[pr]>pivot);
            if(pl<pr){
                int temp = A[pl];
                A[pl] = A[pr];
                A[pr] = temp;
            }
        }
        return pr;
    }

}


