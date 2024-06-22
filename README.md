### Các phương thức vẽ

1. **`fun drawARGB(a: Int, r: Int, g: Int, b: Int)`**
   - **Mô tả:** Vẽ toàn bộ canvas với màu ARGB được chỉ định.
   - **Tham số:**
        - `a`: Giá trị alpha (độ trong suốt) từ 0 đến 255.
        - `r`: Giá trị màu đỏ từ 0 đến 255.
        - `g`: Giá trị màu xanh lá từ 0 đến 255.
        - `b`: Giá trị màu xanh dương từ 0 đến 255.

2. **`fun drawBitmap(bitmap: Bitmap, left: Float, top: Float, paint: Paint?)`**
   - **Mô tả:** Vẽ bitmap được chỉ định tại tọa độ đã cho, với paint được chỉ định.
   - **Tham số:**
        - `bitmap`: Đối tượng Bitmap cần vẽ.
        - `left`: Tọa độ x của góc trên bên trái bitmap.
        - `top`: Tọa độ y của góc trên bên trái bitmap.
        - `paint`: Đối tượng Paint tùy chọn để vẽ bitmap.

3. **`fun drawBitmap(bitmap: Bitmap, src: Rect?, dst: RectF, paint: Paint?)`**
   - **Mô tả:** Vẽ bitmap được chỉ định, tự động co giãn/dịch chuyển để lấp đầy hình chữ nhật đích.
   - **Tham số:**
        - `bitmap`: Đối tượng Bitmap cần vẽ.
        - `src`: Hình chữ nhật xác định phần bitmap cần vẽ (có thể null để vẽ toàn bộ).
        - `dst`: Hình chữ nhật đích để vẽ bitmap, được co giãn/dịch chuyển tự động.
        - `paint`: Đối tượng Paint tùy chọn để vẽ bitmap.

4. **`fun drawBitmap(bitmap: Bitmap, src: Rect?, dst: Rect, paint: Paint?)`**
   - **Mô tả:** Vẽ bitmap được chỉ định, tự động co giãn/dịch chuyển để lấp đầy hình chữ nhật đích.
   - **Tham số:**
        - `bitmap`: Đối tượng Bitmap cần vẽ.
        - `src`: Hình chữ nhật xác định phần bitmap cần vẽ (có thể null để vẽ toàn bộ).
        - `dst`: Hình chữ nhật đích để vẽ bitmap, được co giãn/dịch chuyển tự động.
        - `paint`: Đối tượng Paint tùy chọn để vẽ bitmap.

5. **`fun drawCircle(cx: Float, cy: Float, radius: Float, paint: Paint)`**
   - **Mô tả:** Vẽ một hình tròn tại tọa độ được chỉ định với bán kính và paint được chỉ định.
   - **Tham số:**
        - `cx`: Tọa độ x của tâm hình tròn.
        - `cy`: Tọa độ y của tâm hình tròn.
        - `radius`: Bán kính của hình tròn.
        - `paint`: Đối tượng Paint để vẽ hình tròn.

6. **`fun drawColor(color: Int)`**
   - **Mô tả:** Vẽ mã màu lên toàn bộ canvas
   - **Tham số:**
        - `color`: Mã màu cần điền lên toàn bộ canvas (ví dụ: `Color.RED`).

7. **`fun drawLine(startX: Float, startY: Float, stopX: Float, stopY: Float, paint: Paint)`**
   - **Mô tả:** Vẽ một đường thẳng giữa các điểm bắt đầu và kết thúc được chỉ định bằng paint được chỉ định.
   - **Tham số:**
        - `startX`: Tọa độ x của điểm bắt đầu.
        - `startY`: Tọa độ y của điểm bắt đầu.
        - `stopX`: Tọa độ x của điểm kết thúc.
        - `stopY`: Tọa độ y của điểm kết thúc.
        - `paint`: Đối tượng Paint để vẽ đường thẳng.

8. **`fun drawOval(oval: RectF, paint: Paint)`**
   - **Mô tả:** Vẽ hình oval được chỉ định bằng paint được chỉ định.
   - **Tham số:**
        - `oval`: Hình chữ nhật xác định kích thước và vị trí của hình oval.
        - `paint`: Đối tượng Paint để vẽ hình oval.

9. **`fun drawPaint(paint: Paint)`**
   - **Mô tả:** Vẽ paint được chỉ định lên toàn bộ canvas.
   - **Tham số:**
        - `paint`: Đối tượng Paint để vẽ lên toàn bộ canvas.

10. **`fun drawPath(path: Path, paint: Paint)`**
    - **Mô tả:** Vẽ path được chỉ định bằng paint được chỉ định.
    - **Tham số:**
        - `path`: Đối tượng Path xác định đường dẫn cần vẽ.
        - `paint`: Đối tượng Paint để vẽ đường dẫn.

11. **`fun drawRect(left: Float, top: Float, right: Float, bottom: Float, paint: Paint)`**
    - **Mô tả:** Vẽ hình chữ nhật sử dụng tọa độ và paint được chỉ định.
    - **Tham số:**
        - `left`: Tọa độ x của cạnh trái hình chữ nhật.
        - `top`: Tọa độ y của cạnh trên hình chữ nhật.
        - `right`: Tọa độ x của cạnh phải hình chữ nhật.
        - `bottom`: Tọa độ y của cạnh dưới hình chữ nhật.
        - `paint`: Đối tượng Paint để vẽ hình chữ nhật.

12. **`fun drawText(text: String, x: Float, y: Float, paint: Paint)`**
    - **Mô tả:** Vẽ văn bản được chỉ định tại tọa độ đã cho bằng paint được chỉ định.
    - **Tham số:**
        - `text`: Chuỗi văn bản cần vẽ.
        - `x`: Tọa độ x của vị trí bắt đầu vẽ văn bản.
        - `y`: Tọa độ y của vị trí bắt đầu vẽ văn bản.
        - `paint`: Đối tượng Paint để vẽ văn bản.

13. **`fun drawPicture(picture: Picture)`**
    - **Mô tả:** Vẽ Picture được chỉ định ( vẽ các phần khác lên Picture rồi vẽ Picture lên canvas).
    - **Tham số:**
        - `picture`: Đối tượng Picture cần vẽ.

14. **`fun drawRoundRect(rect: RectF, rx: Float, ry: Float, paint: Paint)`**
    - **Mô tả:** Vẽ hình chữ nhật với các góc bo tròn.
    - **Tham số:**
        - `rect`: Hình chữ nhật xác định kích thước và vị trí của hình chữ nhật có góc tròn.
        - `rx`: Bán kính của góc tròn theo trục x.
        - `ry`: Bán kính của góc tròn theo trục y.
        - `paint`: Đối tượng Paint để vẽ hình chữ nhật có góc tròn.

### Các phương thức biến đổi

15. **`fun rotate(degrees: Float)`**
    - **Mô tả:** xoay toàn bộ tọa độ hình vẽ sau phương thức này.
    - **Tham số:**
        - `degrees`: Góc quay tính bằng độ.

16. **`fun scale(sx: Float, sy: Float)`**
    -  **Mô tả:** Co dãn toàn bộ tọa độ.
    - **Tham số:**
        - `sx`: Hệ số co giãn theo trục x.
        - `sy`: Hệ số co giãn theo trục y.

17. **`fun scale(sx: Float, sy: Float, px: Float, py: Float)`**
    -  **Mô tả:** Co dãn toàn bộ tọa độ với tại tâm chỉ định
    - **Tham số:**
        - `sx`: Hệ số co giãn theo trục x.
        - `sy`: Hệ số co giãn theo trục y.
        - `px`: Tọa độ x của điểm gốc co giãn.
        - `py`: Tọa độ y của điểm gốc co giãn.

18. **`fun skew(sx: Float, sy: Float)`**
    - **Tham số:**
        - `sx`: Hệ số xiên theo trục x.
        - `sy`: Hệ số xiên theo trục y.

19. **`fun translate(dx: Float, dy: Float)`**
    - **Mô tả:** Dich chuyển tọa độ
        - `dx`: Khoảng dịch chuyển theo trục x.
        - `dy`: Khoảng dịch chuyển theo trục y.

### Các phương thức trạng thái

20. **`fun save()`**
    Lưu ma trận và clip hiện tại vào ngăn xếp riêng.

21. **`fun restore()`**
    Khôi phục ma trận và clip hiện tại thành trạng thái trước khi gọi `save()` .

22. **`fun saveLayer(bounds: RectF?, paint: Paint?): Int`**
    - **Mô tả:** Lưu ma trận và clip hiện tại vào ngăn xếp riêng. và cấp phát một vùng ghi đệm (có thể hiểu vùng này độc lập giống như bitmap vẽ tất cả các thứ sau lên này gần giống với vẽ lên bitmap rồi vẽ bitmap vào Canvas)
    - **Tham số:**
        - `bounds`: Hình chữ nhật xác định vùng cần lưu.
        - `paint`: Đối tượng Paint tùy chọn cho lớp mới.
        - Trả về giá trị nguyên đại diện cho trạng thái đã lưu.

23. **`fun saveLayerAlpha(bounds: RectF?, alpha: Int): Int`**
    - **Mô tả:** Giống như saveLayer, nhưng cũng áp dụng alpha được chỉ định cho lớp mới.
    - **Tham số:**
        - `bounds`: Hình chữ nhật xác định vùng cần lưu.
        - `alpha`: Giá trị alpha (độ trong suốt) từ 0 đến 255.
        - Trả về giá trị nguyên đại diện cho trạng thái đã lưu.

### Các phương thức cắt (clipping)

24. **`fun clipRect(left: Float, top: Float, right: Float, bottom: Float): Boolean`**
    - **Mô tả:** Cắt bỏ tất cả thứ khác ngoài hình chữ nhật ( chỉ hiển thị trong hình chữ nhật)
    - **Tham số:**
        - `left`: Tọa độ x của cạnh trái vùng cắt.
        - `top`: Tọa độ y của cạnh trên vùng cắt.
        - `right`: Tọa độ x của cạnh phải vùng cắt.
        - `bottom`: Tọa độ y của cạnh dưới vùng cắt.
        - Trả về `true` nếu vùng cắt thay đổi, ngược lại trả về `false`.

25. **`fun clipPath(path: Path): Boolean`**
    - **Mô tả:** Tương tự cắt bỏ tất cả ngoài vùng bao của path
    - **Tham số:**
        - `path`: Đối tượng Path xác định đường dẫn vùng cắt.
        - Trả về `true` nếu vùng cắt thay đổi, ngược lại trả về `false`.

### Các phương thức truy cập

26. **`fun getWidth(): Int`**
    Trả về chiều rộng của canvas hiện tại.

27. **`fun getHeight(): Int`**
    Trả về chiều cao của canvas hiện tại.


