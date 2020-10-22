public class quick_sort {

        public static void quickSort(int[] input) {
            quickSort(input,0,input.length-1);
            /* Your class should be named Solution
             * Don't write main().
             * Don't read input, it is passed as function argument.
             * No need to print or return the output.
             * Taking input and printing output is handled automatically.
             */

        }
        public static void quickSort(int[] input,int si, int ei)
        {
            if(si>=ei)
                return;
            int count=partition(input,si,ei);
            quickSort(input,si,count-1);
            quickSort(input,count+1,ei);

        }
        public static int partition(int[] input,int si, int ei)
        {
            int count=0;
            for(int i=si+1; i<=ei; i++)
            {
                if(input[i]<=input[si])
                    count++;
            }
            int temp=input[count+si];
            input[count+si]=input[si];
            input[si]=temp;
            int i=si, j=ei;
            for(;i<count+si&&j>si+count;)
            {
                if(input[i]<=input[count+si])
                    i++;
                else if(input[j]>input[count+si])
                    j--;
                else
                {
                    int temp2=input[i];
                    input[i]=input[j];
                    input[j]=temp2;
                    i++;
                    j--;
                }
            }
            return count+si;
        }

    }

