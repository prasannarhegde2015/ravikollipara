Sub genrandnumber()
'' To Add Rows
 Dim MyObject As Object    ' Create object variable.
  Set MyObject = Sheets(1)    ' Create valid object reference.
  MyCount = MyObject.Cells(2, 8)
  L1rngStr = MyObject.Cells(2, 1)
  L2rngStr = MyObject.Cells(2, 2)
  L3rngStr = MyObject.Cells(2, 3)
  For i = 3 To MyCount
     Randomize
    'Random whole number between 1 and 50 :
    random_number = Int(50 * Rnd) + 1
    ls1 = Split(L1rngStr, ";")
    ls2 = Split(L2rngStr, ";")
    ls3 = Split(L3rngStr, ";")
    L1RandomNumber = Int((ls1(1) - ls1(0) + 1) * Rnd + ls1(0))
    L2RandomNumber = Int((ls2(1) - ls2(0) + 1) * Rnd + ls2(0))
    L3RandomNumber = Int((ls3(1) - ls3(0) + 1) * Rnd + ls3(0))
    MyObject.Cells(i, 1) = L1RandomNumber
    MyObject.Cells(i, 2) = L2RandomNumber
    MyObject.Cells(i, 3) = L3RandomNumber
    
    MyObject.Cells(i, 4) = random_number
    MyObject.Cells(i, 5) = RandomString(20)
  
  Next







End Sub

Function RandomString(Length As Integer)
'PURPOSE: Create a Randomized String of Characters
'SOURCE: www.TheSpreadsheetGuru.com/the-code-vault

Dim CharacterBank As Variant
Dim x As Long
Dim str As String

'Test Length Input
  If Length < 1 Then
    MsgBox "Length variable must be greater than 0"
    Exit Function
  End If

CharacterBank = Array("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", _
  "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", _
  "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "@", _
  "#", "$", "%", "^", "&", "*", "A", "B", "C", "D", "E", "F", "G", "H", _
  "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", _
  "W", "X", "Y", "Z")
  
  CharacterBank2 = Array(" Sunday ", " is ", " Holiday ", " Monday ", " Working ", " Friday ", " CompOff ")
  

'Randomly Select Characters One-by-One
  For x = 1 To Length
    Randomize
   ' str = str & CharacterBank(Int((UBound(CharacterBank) - LBound(CharacterBank) + 1) * Rnd + LBound(CharacterBank)))
    str = str & CharacterBank(Int(UBound(CharacterBank) * Rnd) + LBound(CharacterBank))
   ' str = str & CharacterBank2(Int(UBound(CharacterBank2) * Rnd) + LBound(CharacterBank2))
  Next x

'Output Randomly Generated String
  RandomString = str

End Function


Sub clear()
Dim MyObject As Object    ' Create object variable.
  Set MyObject = Sheets(1)
Set Rng = MyObject.Range(Cells(3, 1), Cells(100, 100))
Rng.clear
ActiveWorkbook.Save

  
End Sub
