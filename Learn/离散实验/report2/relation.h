//
// Created by zhy on 10/19/16.
//

#ifndef REPORT2_RELATION_H
#define REPORT2_RELATION_H


class relation {
public:
    relation(){};
    ~relation();
    void initialize();
    bool isReflexive();
    bool isSymmetry();
    bool isTransitivity();
    bool isNotReflexive();
    bool isNotSymmetry();
    void show();
    void judge();
private:
    int **matrix;
    int dense;
};
#endif //REPORT2_RELATION_H
