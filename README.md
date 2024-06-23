# Các phương thức của lớp Path trong Android

1. **addArc(oval: RectF ,startAngle: Float, sweepAngle: Float): Path**
   - **Mô tả:** Thêm một đoạn cung vào đường dẫn.
   - **Tham số:**
     - `oval`: Hình chữ nhật xác định hình elip.
     - `startAngle`: Góc bắt đầu (độ).
     - `sweepAngle`: Góc quét (độ).

2. **addCircle( x: Float, y: Float, radius: Float, dir: Path.Direction): Path**
   - **Mô tả:** Thêm một đường tròn vào đường dẫn.
   - **Tham số:**
     - `x`: Tọa độ X của tâm.
     - `y`: Tọa độ Y của tâm.
     - `radius`: Bán kính của đường tròn.
     - `dir`: Hướng của đường đi (CW - chiều kim đồng hồ, CCW - ngược chiều kim đồng hồ).

3. **addOval( oval: RectF, dir: Path.Direction): Path**
   - **Mô tả:** Thêm một hình elip vào đường dẫn.
   - **Tham số:**
     - `oval`: Hình chữ nhật xác định hình elip.
     - `dir`: Hướng của đường đi (CW - chiều kim đồng hồ, CCW - ngược chiều kim đồng hồ).

4. **addPath( src: Path): Path**
   - **Mô tả:** Thêm một đường dẫn khác vào đường dẫn hiện tại.
   - **Tham số:**
     - `src`: Đường dẫn cần thêm vào.

5. **addRect( left: Float, top: Float, right: Float, bottom: Float, dir: Path.Direction): Path**
   - **Mô tả:** Thêm một hình chữ nhật vào đường dẫn.
   - **Tham số:**
     - `left`: Tọa độ X của cạnh trái.
     - `top`: Tọa độ Y của cạnh trên.
     - `right`: Tọa độ X của cạnh phải.
     - `bottom`: Tọa độ Y của cạnh dưới.
     - `dir`: Hướng của đường đi (CW - chiều kim đồng hồ, CCW - ngược chiều kim đồng hồ).

6. **addRoundRect( rect: RectF, radii: FloatArray, Path.Direction dir): Path**
   - **Mô tả:** Thêm một hình chữ nhật bo góc vào đường dẫn.
   - **Tham số:**
     - `rect`: Hình chữ nhật xác định hình dạng.
     - `radii`: Mảng chứa bán kính của từng góc.
     - `dir`: Hướng của đường đi (CW - chiều kim đồng hồ, CCW - ngược chiều kim đồng hồ).

7. **arcTo( oval: RectF, startAngle: Float, sweepAngle: Float, forceMoveTo: Float): Path**
   - **Mô tả:** Thêm một đoạn cung vào đường dẫn.
   - **Tham số:**
     - `oval`: Hình chữ nhật xác định hình elip.
     - `startAngle`: Góc bắt đầu (độ).
     - `sweepAngle`: Góc quét (độ).
     - `forceMoveTo`: Nếu true, di chuyển đến điểm bắt đầu của đoạn cung.

8. **close(): Path**
   - **Mô tả:** Đóng đường dẫn hiện tại.

9. **cubicTo( x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float): Path**
   - **Mô tả:** Thêm một đường cong bậc ba vào đường dẫn ( [vào trang này xem thử dễ tưởng tượng hơn](https://math.hws.edu/eck/cs424/notes2013/canvas/bezier.html) ) .
   - **Tham số:**
     - `x1`: Tọa độ X của điểm điều khiển đầu tiên.
     - `y1`: Tọa độ Y của điểm điều khiển đầu tiên.
     - `x2`: Tọa độ X của điểm điều khiển thứ hai.
     - `y2`: Tọa độ Y của điểm điều khiển thứ hai.
     - `x3`: Tọa độ X của điểm kết thúc.
     - `y3`: Tọa độ Y của điểm kết thúc.

10. **lineTo( x: Float, y: Float): Path**
    - **Mô tả:** Thêm một đoạn thẳng từ điểm hiện tại đến tọa độ mới.
    - **Tham số:**
      - `x`: Tọa độ X của điểm kết thúc.
      - `y`: Tọa độ Y của điểm kết thúc.

11. **moveTo( x: Float, y: Float): Path**
    - **Mô tả:** Di chuyển điểm bắt đầu của đường dẫn đến tọa độ mới.
    - **Tham số:**
      - `x`: Tọa độ X mới.
      - `y`: Tọa độ Y mới.

12. **quadTo( x1: Float, y1: Float, x2: Float, y2: Float): Path**
    - **Mô tả:** Thêm một đường cong bậc hai vào đường dẫn ( [vào trang này xem thử dễ tưởng tượng hơn](https://math.hws.edu/eck/cs424/notes2013/canvas/bezier.html) ).
    - **Tham số:**
      - `x1`: Tọa độ X của điểm điều khiển.
      - `y1`: Tọa độ Y của điểm điều khiển.
      - `x2`: Tọa độ X của điểm kết thúc.
      - `y2`: Tọa độ Y của điểm kết thúc.

13. **reset(): Path**
    - **Mô tả:** Xóa tất cả các thành phần trong đường dẫn, đặt nó trở về trạng thái rỗng.

14. **rewind(): Path**
    - **Mô tả:** Xóa tất cả các thành phần trong đường dẫn nhưng giữ lại các thuộc tính nội tại.

15. **set( src: Path): Path**
    - **Mô tả:** Đặt lại đường dẫn hiện tại theo đường dẫn được cung cấp.
    - **Tham số:**
      - `src`: Đường dẫn để đặt lại.

16. **transform( matrix: Matrix): Path**
    - **Mô tả:** Áp dụng một ma trận biến đổi lên đường dẫn.
    - **Tham số:**
      - `matrix`: Ma trận biến đổi cần áp dụng.

17. **op( path: Path, op: Path.Op): boolean**
    - **Mô tả:** Thực hiện một thao tác Boolean giữa đường dẫn hiện tại và đường dẫn khác.
    - **Tham số:**
      - `path`: Đường dẫn cần thao tác.
      - `op`: Loại thao tác (DIFFERENCE, INTERSECT, UNION, XOR, REVERSE_DIFFERENCE).

18. **addRoundRect( rect: RectF, rx: Float, ry: Float, dir: Path.Direction): Path**
    - **Mô tả:** Thêm một hình chữ nhật bo góc vào đường dẫn.
    - **Tham số:**
      - `rect`: Hình chữ nhật xác định hình dạng.
      - `rx`: Bán kính góc x.
      - `ry`: Bán kính góc y.
      - `dir`: Hướng của đường đi (CW - chiều kim đồng hồ, CCW - ngược chiều kim đồng hồ).

19. **rLineTo( dx: Float, dy: Float): Path**
    - **Mô tả:** Thêm một đoạn thẳng tương đối từ điểm hiện tại.
    - **Tham số:**
      - `dx`: Khoảng cách theo trục X.
      - `dy`: Khoảng cách theo trục Y.

20. **rMoveTo( dx: Float, dy: Float): Path**
    - **Mô tả:** Di chuyển điểm bắt đầu của đường dẫn tương đối.
    - **Tham số:**
      - `dx`: Khoảng cách theo trục X.
      - `dy`: Khoảng cách theo trục Y.

21. **rQuadTo( dx1: Float, dy1: Float, dx2: Float, dy2: Float): Path**
    - **Mô tả:** Thêm một đường cong bậc hai tương đối vào đường dẫn.
    - **Tham số:**
      - `dx1`: Khoảng cách X của điểm điều khiển.
      - `dy1`: Khoảng cách Y của điểm điều khiển.
      - `dx2`: Khoảng cách X của điểm kết thúc.
      - `dy2`: Khoảng cách Y của điểm kết thúc.

22. **rCubicTo( dx1: Float, dy1: Float, dx2: Float, dy2: Float, dx3: Float, dy3: Float): Path**
    - **Mô tả:** Thêm một đường cong bậc ba tương đối vào đường dẫn.
    - **Tham số:**
      - `dx1`: Khoảng cách X của điểm điều khiển đầu tiên.
      - `dy1`: Khoảng cách Y của điểm điều khiển đầu tiên.
      - `dx2`: Khoảng cách X của điểm điều khiển thứ hai.
      - `dy2`: Khoảng cách Y của điểm điều khiển thứ hai.
      - `dx3`: Khoảng cách X của điểm kết thúc.
      - `dy3`: Khoảng cách Y của điểm kết thúc.

23. **isEmpty(): boolean**
    - **Mô tả:** Kiểm tra xem đường dẫn có rỗng hay không.

24. **isRect( rect: RectF): boolean**
    - **Mô tả:** Kiểm tra xem đường dẫn có phải là một hình chữ nhật hay không.
    - **Tham số:**
      - `rect`: Hình chữ nhật để kiểm tra.

25. **computeBounds( bounds: RectF, exact: Boolean): void**
    - **Mô tả:** Tính toán giới hạn bao quanh đường dẫn.
    - **Tham số:**
      - `bounds`: Hình chữ nhật để lưu trữ giới hạn.
      - `exact`: Nếu true, tính toán chính xác.

26. **offset( dx: Float, dy: Float): void**
    - **Mô tả:** Dời đường dẫn theo tọa độ đã cho.
    - **Tham số:**
      - `dx`: Khoảng cách X để dời.
      - `dy`: Khoảng cách Y để dời.
