import pandas as pd

from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWidgets import QFileDialog

from main import *


class Ui_MainWindow(object):
    file = 0
    matrixA = 0

    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(600, 600)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.pushButton = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton.setGeometry(QtCore.QRect(20, 10, 121, 51))
        self.pushButton.setObjectName("pushButton")
        self.pushButton.clicked.connect(self.openfile)

        self.pushButton_2 = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton_2.setGeometry(QtCore.QRect(260, 490, 93, 28))
        self.pushButton_2.setStyleSheet("border-radius:10px;")
        self.pushButton_2.setObjectName("pushButton_2")
        self.pushButton_2.clicked.connect(self.countbyiteration)
        self.pushButton_2.setDisabled(True)

        self.pushButton_3 = QtWidgets.QPushButton(self.centralwidget)
        self.pushButton_3.setGeometry(QtCore.QRect(400, 490, 93, 28))
        self.pushButton_3.setStyleSheet("border-radius:10px;")
        self.pushButton_3.setObjectName("pushButton_3")
        self.pushButton_3.clicked.connect(self.countbyprecision)
        self.pushButton_3.setDisabled(True)

        self.label = QtWidgets.QLabel(self.centralwidget)
        font = QtGui.QFont()
        font.setFamily("Verdana")
        font.setPointSize(11)
        self.label.setFont(font)

        self.label.setGeometry(QtCore.QRect(150, 30, 380, 50))
        self.label.setObjectName("label")
        self.lineEdit = QtWidgets.QLineEdit(self.centralwidget)
        self.lineEdit.setGeometry(QtCore.QRect(140, 487, 80, 30))
        self.lineEdit.setStyleSheet("border-radius:10px;")
        self.lineEdit.setObjectName("lineEditdigit")

        self.gridLayoutWidget = QtWidgets.QWidget(self.centralwidget)
        self.gridLayoutWidget.setGeometry(QtCore.QRect(25, 100, 550, 300))
        self.gridLayoutWidget.setObjectName("gridLayoutWidget")
        self.gridLayout = QtWidgets.QGridLayout(self.gridLayoutWidget)
        self.gridLayout.setContentsMargins(0, 0, 0, 0)
        self.gridLayout.setObjectName("gridLayout")

        MainWindow.setCentralWidget(self.centralwidget)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.widget = QtWidgets.QWidget(self.centralwidget)
        self.widget.setGeometry(QtCore.QRect(210, 110, 171, 211))
        self.widget.setObjectName("widget")

        self.widget_2 = QtWidgets.QWidget(self.centralwidget)
        self.widget_2.setGeometry(QtCore.QRect(120, 110, 406, 301))
        self.widget_2.setStyleSheet("background-image:url(./images/resultprof.jpg);border-radius:10px;")
        self.widget_2.setObjectName("widget_2")
        self.widget_2.setVisible(False)

        self.label_3 = QtWidgets.QLabel(self.widget_2)
        self.label_3.setGeometry(QtCore.QRect(20, 100, 290, 181))
        self.label_3.setStyleSheet("background:none;color:none;")
        self.label_3.setObjectName("label_3")
        font.setPointSize(10)
        self.label_3.setFont(font)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "MainWindow"))
        self.pushButton.setText(_translate("MainWindow", "Load from file "))
        self.pushButton_3.setText(_translate("MainWindow", "xn-xn-1<E"))
        self.pushButton_2.setText(_translate("MainWindow", "Iteration"))
        self.label.setText(_translate("MainWindow", "Load matrix from file!"))

    def creategrid(self):
        k = 0
        font = QtGui.QFont()
        font.setPointSize(20 - (len(file[0]) + 4))

        for i in range(len(file)):
            for j in range((len(file[0]) * 2) - 1):
                if j == (len(file[0]) * 2) - 2:
                    label = QtWidgets.QLabel(self.gridLayoutWidget)
                    label.setText("= " + str(file[i][k]))
                    label.setStyleSheet("text-align: center")
                    label.setFont(font)
                    self.gridLayout.addWidget(label, i, j, 1, 1)
                elif j % 2 == 0:
                    label = QtWidgets.QLabel(self.gridLayoutWidget)
                    text = ""
                    if file[i][k] >= 0:
                        text = "+"
                    label.setText(text + str(file[i][k]))
                    label.setStyleSheet("text-align: center")
                    label.setFont(font)
                    self.gridLayout.addWidget(label, i, j, 1, 1)
                    k += 1
                else:
                    label = QtWidgets.QLabel(self.gridLayoutWidget)
                    label.setText(" x" + str(k))
                    label.setFont(font)
                    label.setStyleSheet("text-align: center")
                    self.gridLayout.addWidget(label, i, j, 1, 1)
            k = 0

    def openfile(self):
        filename = QFileDialog.getOpenFileName()
        filee = pd.read_csv(filename[0], header=None, dtype=float)
        global file
        file = filee.values.tolist()
        file = change(file)
        global matrixA
        matrixA = checkMatrix(file)
        convergence = check_convergence(matrixA)
        if not matrixA:
            self.label.setText("Matrix has zeros on its main diagonal \n or not enough number of equations ")
        elif not convergence:
            self.label.setText("Macierz nie jest przekątniowo dominujaca")
        else:
            self.widget.setVisible(False)
            self.label.setText("Matrix is correct")
            self.creategrid()
            self.pushButton_2.setDisabled(False)
            self.pushButton_3.setDisabled(False)
            self.pushButton.setVisible(False)

    def countbyiteration(self):
        result, iteration = count(int(self.lineEdit.text()), True, file, matrixA)
        self.setresult(result, iteration)
        self.label.setVisible(False)

    def countbyprecision(self):
        result, iteration = count(float(self.lineEdit.text()), False, file, matrixA)
        self.setresult(result, iteration)
        self.label.setVisible(False)

    def setresult(self, result, iteration):
        text = ""
        for i in range(len(result)):
            text += "x" + str(i + 1) + " = " + str(result[i]) + "\n"
        text += "\nIteration: " + str(iteration)
        self.gridLayoutWidget.setVisible(False)
        self.widget_2.setVisible(True)
        font = QtGui.QFont()
        font.setPointSize(10)
        self.label_3.setFont(font)
        self.label_3.setText(text)
        self.lineEdit.setVisible(False)
        self.pushButton_2.setVisible(False)
        self.pushButton_3.setVisible(False)


if __name__ == "__main__":
    import sys

    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    MainWindow.setStyleSheet("#MainWindow {"
                             "background:black;"
                             "}"
                             "#centralwidget{\n"
                             "background:url(./images/tlo.jpg);\n"
                             "}\n"
                             "\n"
                             "#widget{\n"
                             "background:url(./images/profesor.jpg);\n"
                             "border-radius:10px;\n"
                             "}\n"

                             "QPushButton \n"
                             "{\n"
                             "    background: #f3f0f1;\n"
                             "    text-align: center;\n"
                             "      border-radius:20px;\n"
                             "    font-family: Verdana;\n"
                             "}\n"
                             "QPushButton:hover\n"
                             "{\n"
                             "    background: white;\n"
                             "}\n"
                             "\n"
                             "QLabel {\n"
                             "    color:white;\n"
                             "    font-weight: bold;"
                             "}\n"
                             "#lineEdit {\n"
                             "    border-radius:10px;\n"
                             "}\n"
                             "")

    ui = Ui_MainWindow()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())
