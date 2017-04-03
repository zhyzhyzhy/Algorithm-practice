#ifndef SORTABLELIST_H
#define SORTABLELIST_H


class SortableList
{
    public:
        SortableList(int mSize) {
            maxSize = mSize;
            l = new int[maxSize];
            n = 0;
        }
        ~SortableList() {
            delete []l;
        }
        void Input();
        void Output();

        void MergeSort();
        void QuickSort();
        int select(int k);
          void InsertSort(int left, int right);


    private:
        int *l;
        int maxSize;
        int n;

        void MergeSort(int left, int right);
        void Merge(int left, int mid, int right);
        void swap(int i, int j) {
            int c = l[i];
            l[i] = l[j];
            l[j] = c;
        }
        void QuickSort(int left, int right);
        int Select(int k, int left, int right, int r);
        int Partition(int left, int right);

};

#endif // SORTABLELIST_H
