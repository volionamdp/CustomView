

# Hệ tọa độ trong View
Trong View android có hệ tọa độ gốc 0.0 ở vị trí trên cùng bên trái 
  - Trục `X` dương hướng sang phải
  - Trục `Y` dương hướng xuống dưới
  - Đơn vị  1 `pixel` (1 diểm ảnh trên màn hình) nên với `mỗi một màn hình sẽ có chiều rộng và cao của view sẽ khác nhau` (muốn sử lí giống nhau với mọi màn hình có để dùng giá trị dp,hoặc phần trăm so với width,height)


![Hệ tọa độ](https://github.com/volionamdp/CustomView/blob/Matrix/image/HeToaDo.png)

# Chú ý
Khi áp dụng Matrix nên gọi `canvas.save()` và khi sử dụng xong gọi  ` canvas.restore()` để trả về trạng thái ban đầu

```kotlin
override fun onDraw(canvas: Canvas) {  
    canvas.save()  
    canvas.setMatrix(matrix1)  
    canvas.drawRect(rectF, paint)  
    canvas.restore()  
  
    canvas.save()  
    canvas.setMatrix(matrix2)  
    canvas.drawRect(rectF, paint)  
    canvas.restore()  
  
    canvas.drawRect(rectF, paint)  
  
}
```
# Matrix
## Các phương thức hay sử dụng
#### Các phương thức khởi tạo và lấy matrix

1. **`fun reset()`**
   - **Mô tả**: Đặt lại ma trận về ma trận đơn vị.
   - **Tham số**: Không có.

2. **`fun setValues(values: FloatArray)`**
   - **Mô tả**: Đặt giá trị của ma trận từ mảng `values`.
   - **Tham số**:
     - `values: FloatArray`: Mảng chứa giá trị của ma trận (cần có độ dài là 9).

3. **`fun getValues(values: FloatArray)`**
   - **Mô tả**: Lấy giá trị của ma trận và lưu vào mảng `values`.
   - **Tham số**:
     - `values: FloatArray`: Mảng để lưu giá trị của ma trận (cần có độ dài là 9).

4. **`fun set(matrix: Matrix)`**
   - **Mô tả**: Sao chép nội dung của `matrix` vào đối tượng `Matrix` hiện tại.
   - **Tham số**:
     - `matrix: Matrix`: Đối tượng `Matrix` nguồn.

5. **`fun isIdentity(): Boolean`**
   - **Mô tả**: Kiểm tra xem đối tượng `Matrix` hiện tại có phải là ma trận đơn vị hay không.
   - **Tham số**: Không có.
   
#### Các phương thức biến đổi (áp dụng) Matrix với tọa độ (vd: tính điểm x,y sau khi áp dụng Matrix tọa độ mới ở vị trí nào thì có thể dùng mapPoints)

6. **`fun mapPoints(dst: FloatArray, src: FloatArray)`**
    - **Mô tả**: Biến đổi các điểm trong mảng `src` và lưu kết quả vào mảng `dst`.
    - **Tham số**:
      - `dst: FloatArray`: Mảng để lưu kết quả biến đổi.
      - `src: FloatArray`: Mảng chứa các điểm nguồn.

7. **`fun mapPoints(dst: FloatArray, dstIndex: Int, src: FloatArray, srcIndex: Int, pointCount: Int)`**
    - **Mô tả**: Biến đổi một số lượng điểm xác định từ mảng `src` bắt đầu từ `srcIndex` và lưu kết quả vào `dst` bắt đầu từ `dstIndex`.
    - **Tham số**:
      - `dst: FloatArray`: Mảng để lưu kết quả biến đổi.
      - `dstIndex: Int`: Vị trí bắt đầu trong `dst`.
      - `src: FloatArray`: Mảng chứa các điểm nguồn.
      - `srcIndex: Int`: Vị trí bắt đầu trong `src`.
      - `pointCount: Int`: Số lượng điểm cần biến đổi.
8. **`fun mapRadius(radius: Float): Float`**
    - **Mô tả**: Biến đổi giá trị bán kính `radius` theo ma trận hiện tại.
    - **Tham số**:
      - `radius: Float`: Giá trị bán kính cần biến đổi.

9. **`fun mapRect(rect: RectF): Boolean`**
    - **Mô tả**: Biến đổi hình chữ nhật `rect` theo ma trận hiện tại.
    - **Tham số**:
      - `rect: RectF`: Hình chữ nhật cần biến đổi.

10. **`fun mapRect(dst: RectF, src: RectF): Boolean`**
    - **Mô tả**: Biến đổi hình chữ nhật `src` và lưu kết quả vào `dst`.
    - **Tham số**:
      - `dst: RectF`: Hình chữ nhật để lưu kết quả biến đổi.
      - `src: RectF`: Hình chữ nhật nguồn.
####    Các phương thức thay đổi matrix hay dùng
11. **`fun postConcat(matrix: Matrix): Boolean`**
    - **Mô tả**: Nhân ma trận hiện tại với `matrix` (sau ma trận hiện tại).
    - **Tham số**:
      - `matrix: Matrix`: Ma trận để nhân.

12. **`fun postRotate(degrees: Float): Boolean`**
    - **Mô tả**: Xoay ma trận hiện tại một góc `degrees` độ (sau các phép biến đổi hiện tại).
    - **Tham số**:
      - `degrees: Float`: Góc xoay tính bằng độ.

13. **`fun postRotate(degrees: Float, px: Float, py: Float): Boolean`**
    - **Mô tả**: Xoay ma trận hiện tại một góc `degrees` độ quanh điểm `(px, py)` (sau các phép biến đổi hiện tại).
    - **Tham số**:
      - `degrees: Float`: Góc xoay tính bằng độ.
      - `px: Float`: Tọa độ x của điểm xoay.
      - `py: Float`: Tọa độ y của điểm xoay.

14. **`fun postScale(sx: Float, sy: Float): Boolean`**
    - **Mô tả**: Tỉ lệ ma trận hiện tại với `sx` và `sy` (sau các phép biến đổi hiện tại).
    - **Tham số**:
      - `sx: Float`: Tỉ lệ theo trục x.
      - `sy: Float`: Tỉ lệ theo trục y.

15. **`fun postScale(sx: Float, sy: Float, px: Float, py: Float): Boolean`**
    - **Mô tả**: Tỉ lệ ma trận hiện tại với `sx` và `sy` quanh điểm `(px, py)` (sau các phép biến đổi hiện tại).
    - **Tham số**:
      - `sx: Float`: Tỉ lệ theo trục x.
      - `sy: Float`: Tỉ lệ theo trục y.
      - `px: Float`: Tọa độ x của điểm trung tâm.
      - `py: Float`: Tọa độ y của điểm trung tâm.

16. **`fun postSkew(kx: Float, ky: Float): Boolean`**
    - **Mô tả**: Nghiêng ma trận hiện tại với `kx` và `ky` (sau các phép biến đổi hiện tại).
    - **Tham số**:
      - `kx: Float`: Giá trị nghiêng theo trục x.
      - `ky: Float`: Giá trị nghiêng theo trục y.

17. **`fun postSkew(kx: Float, ky: Float, px: Float, py: Float): Boolean`**
    - **Mô tả**: Nghiêng ma trận hiện tại với `kx` và `ky` quanh điểm `(px, py)` (sau các phép biến đổi hiện tại).
    - **Tham số**:
      - `kx: Float`: Giá trị nghiêng theo trục x.
      - `ky: Float`: Giá trị nghiêng theo trục y.
      - `px: Float`: Tọa độ x của điểm trung tâm.
      - `py: Float`: Tọa độ y của điểm trung tâm.

18. **`fun postTranslate(dx: Float, dy: Float): Boolean`**
    - **Mô tả**: Dịch chuyển ma trận hiện tại theo `dx` và `dy` (sau các phép biến đổi hiện tại).
    - **Tham số**:
      - `dx: Float`: Khoảng dịch chuyển theo trục x.
      - `dy: Float`: Khoảng dịch chuyển theo trục y.
19. **`fun invert(inverse: Matrix): Boolean`**
    - **Mô tả**: Lấy ma trận nghịch đảo của ma trận hiện tại và lưu vào `inverse`.
    - **Tham số**:
      - `inverse: Matrix`: Ma trận để lưu ma trận nghịch đảo.

20. **`fun setRotate(degrees: Float)`**
    - **Mô tả**: Đặt ma trận hiện tại thành ma trận xoay một góc `degrees` độ.
    - **Tham số**:
      - `degrees: Float`: Góc xoay tính bằng độ.

21. **`fun setRotate(degrees: Float, px: Float, py: Float)`**
    - **Mô tả**: Đặt ma trận hiện tại thành ma trận xoay một góc `degrees` độ quanh điểm `(px, py)`.
    - **Tham số**:
      - `degrees: Float`: Góc xoay tính bằng độ.
      - `px: Float`: Tọa độ x của điểm xoay.
      - `py: Float`: Tọa độ y của điểm xoay.

22. **`fun setScale(sx: Float, sy: Float)`**
    - **Mô tả**: Đặt ma trận hiện tại thành ma trận tỉ lệ với `sx` và `sy`.
    - **Tham số**:
      - `sx: Float`: Tỉ lệ theo trục x.
      - `sy: Float`: Tỉ lệ theo trục y.

23. **`fun setScale(sx: Float, sy: Float, px: Float, py: Float)`**
    - **Mô tả**: Đặt ma trận hiện tại thành ma trận tỉ lệ với `sx` và `sy` quanh điểm `(px, py)`.
    - **Tham số**:
      - `sx: Float`: Tỉ lệ theo trục x.
      - `sy: Float`: Tỉ lệ theo trục y.
      - `px: Float`: Tọa độ x của điểm trung tâm.
      - `py: Float`: Tọa độ y của điểm trung tâm.
24. **`fun setTranslate(dx: Float, dy: Float)`**
    - **Mô tả**: Đặt ma trận hiện tại thành ma trận dịch chuyển với `dx` và `dy`.
    - **Tham số**:
      - `dx: Float`: Khoảng dịch chuyển theo trục x.
      - `dy: Float`: Khoảng dịch chuyển theo trục y.
## Phương thức ít sử dụng hơn
25. **`fun preConcat(matrix: Matrix): Boolean`**
    - **Mô tả**: Nhân ma trận hiện tại với `matrix` (trước ma trận hiện tại).
    - **Tham số**:
      - `matrix: Matrix`: Ma trận để nhân.

26. **`fun preRotate(degrees: Float): Boolean`**
    - **Mô tả**: Xoay ma trận hiện tại một góc `degrees` độ (trước các phép biến đổi hiện tại).
    - **Tham số**:
      - `degrees: Float`: Góc xoay tính bằng độ.

27. **`fun preRotate(degrees: Float, px: Float, py: Float): Boolean`**
    - **Mô tả**: Xoay ma trận hiện tại một góc `degrees` độ quanh điểm `(px, py)` (trước các phép biến đổi hiện tại).
    - **Tham số**:
      - `degrees: Float`: Góc xoay tính bằng độ.
      - `px: Float`: Tọa độ x của điểm xoay.
      - `py: Float`: Tọa độ y của điểm xoay.

28. **`fun preScale(sx: Float, sy: Float): Boolean`**
    - **Mô tả**: Tỉ lệ ma trận hiện tại với `sx` và `sy` (trước các phép biến đổi hiện tại).
    - **Tham số**:
      - `sx: Float`: Tỉ lệ theo trục x.
      - `sy: Float`: Tỉ lệ theo trục y.

29. **`fun preScale(sx: Float, sy: Float, px: Float, py: Float): Boolean`**
    - **Mô tả**: Tỉ lệ ma trận hiện tại với `sx` và `sy` quanh điểm `(px, py)` (trước các phép biến đổi hiện tại).
    - **Tham số**:
      - `sx: Float`: Tỉ lệ theo trục x.
      - `sy: Float`: Tỉ lệ theo trục y.
      - `px: Float`: Tọa độ x của điểm trung tâm.
      - `py: Float`: Tọa độ y của điểm trung tâm.

30. **`fun preSkew(kx: Float, ky: Float): Boolean`**
    - **Mô tả**: Nghiêng ma trận hiện tại với `kx` và `ky` (trước các phép biến đổi hiện tại).
    - **Tham số**:
      - `kx: Float`: Giá trị nghiêng theo trục x.
      - `ky: Float`: Giá trị nghiêng theo trục y.

31. **`fun preSkew(kx: Float, ky: Float, px: Float, py: Float): Boolean`**
    - **Mô tả**: Nghiêng ma trận hiện tại với `kx` và `ky` quanh điểm `(px, py)` (trước các phép biến đổi hiện tại).
    - **Tham số**:
      - `kx: Float`: Giá trị nghiêng theo trục x.
      - `ky: Float`: Giá trị nghiêng theo trục y.
      - `px: Float`: Tọa độ x của điểm trung tâm.
      - `py: Float`: Tọa độ y của điểm trung tâm.

32. **`fun preTranslate(dx: Float, dy: Float): Boolean`**
    - **Mô tả**: Dịch chuyển ma trận hiện tại theo `dx` và `dy` (trước các phép biến đổi hiện tại).
    - **Tham số**:
      - `dx: Float`: Khoảng dịch chuyển theo trục x.
      - `dy: Float`: Khoảng dịch chuyển theo trục y.

33. **`fun setSinCos(sinValue: Float, cosValue: Float)`**
    - **Mô tả**: Đặt ma trận hiện tại thành ma trận xoay với giá trị sin và cos cho trước.
    - **Tham số**:
      - `sinValue: Float`: Giá trị sin của góc xoay.
      - `cosValue: Float`: Giá trị cos của góc xoay.

34. **`fun setSinCos(sinValue: Float, cosValue: Float, px: Float, py: Float)`**
    - **Mô tả**: Đặt ma trận hiện tại thành ma trận xoay với giá trị sin và cos cho trước quanh điểm `(px, py)`.
    - **Tham số**:
      - `sinValue: Float`: Giá trị sin của góc xoay.
      - `cosValue: Float`: Giá trị cos của góc xoay.
      - `px: Float`: Tọa độ x của điểm xoay.
      - `py: Float`: Tọa độ y của điểm xoay.

35. **`fun setSkew(kx: Float, ky: Float)`**
    - **Mô tả**: Đặt ma trận hiện tại thành ma trận nghiêng với `kx` và `ky`.
    - **Tham số**:
      - `kx: Float`: Giá trị nghiêng theo trục x.
      - `ky: Float`: Giá trị nghiêng theo trục y.

36. **`fun setSkew(kx: Float, ky: Float, px: Float, py: Float)`**
    - **Mô tả**: Đặt ma trận hiện tại thành ma trận nghiêng với `kx` và `ky` quanh điểm `(px, py)`.
    - **Tham số**:
      - `kx: Float`: Giá trị nghiêng theo trục x.
      - `ky: Float`: Giá trị nghiêng theo trục y.
      - `px: Float`: Tọa độ x của điểm trung tâm.
      - `py: Float`: Tọa độ y của điểm trung tâm.

37. **`fun mapVectors(dst: FloatArray, src: FloatArray)`**
    - **Mô tả**: Biến đổi các vector trong mảng `src` và lưu kết quả vào mảng `dst`.
    - **Tham số**:
      - `dst: FloatArray`: Mảng để lưu kết quả biến đổi.
      - `src: FloatArray`: Mảng chứa các vector nguồn.

38. **`fun mapVectors(dst: FloatArray, dstIndex: Int, src: FloatArray, srcIndex: Int, vectorCount: Int)`**
    - **Mô tả**: Biến đổi một số lượng vector xác định từ mảng `src` bắt đầu từ `srcIndex` và lưu kết quả vào `dst` bắt đầu từ `dstIndex`.
    - **Tham số**:
      - `dst: FloatArray`: Mảng để lưu kết quả biến đổi.
      - `dstIndex: Int`: Vị trí bắt đầu trong `dst`.
      - `src: FloatArray`: Mảng chứa các vector nguồn.
      - `srcIndex: Int`: Vị trí bắt đầu trong `src`.
      - `vectorCount: Int`: Số lượng vector cần biến đổi.

39. **`fun rectStaysRect(): Boolean`**
    - **Mô tả**: Kiểm tra xem phép biến đổi của ma trận hiện tại có giữ hình chữ nhật không bị biến dạng (vẫn là hình chữ nhật) hay không.
    - 
 40. **`fun times(matrix: Matrix): Matrix`**
   - **Mô tả**: Nhân ma trận hiện tại với `matrix` và trả về ma trận kết quả.
   - **Tham số**:
     - `matrix: Matrix`: Ma trận để nhân.

41. **`fun get(row: Int, col: Int): Float`**
   - **Mô tả**: Lấy giá trị phần tử tại vị trí `row` và `col` trong ma trận.
   - **Tham số**:
     - `row: Int`: Chỉ số hàng.
     - `col: Int`: Chỉ số cột.
42. **`fun set(row: Int, col: Int, value: Float)`**
   - **Mô tả**: Đặt giá trị phần tử tại vị trí `row` và `col` trong ma trận.
   - **Tham số**:
     - `row: Int`: Chỉ số hàng.
     - `col: Int`: Chỉ số cột.
     - `value: Float`: Giá trị cần đặt.
