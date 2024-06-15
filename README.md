### Vòng đời của một View trong Android

Vòng đời của một View trong Android mô tả các trạng thái mà View đó có thể trải qua từ khi được tạo ra đến khi bị hủy bỏ hoặc không còn cần thiết

1. **init (Khởi tạo)**

   - **Constructor**: View được tạo ra bằng cách gọi constructor của lớp đó (ví dụ: `new View(context)`).
   - **Inflate từ XML**: View được tạo bằng cách inflate từ một file XML layout (`LayoutInflater.from(context).inflate(R.layout.my_layout, parent, false)`).

2. **onMeasure,onLayout  (Xác định kích thước và vị trí của view)**

   - **onMeasure**: Phương thức này được gọi để xác định kích thước mà View muốn có. Thông thường, nó sẽ gọi `setMeasuredDimension(width, height)` để đặt kích thước cho View.
   - **onLayout**: Phương thức này được gọi để đặt vị trí và kích thước cuối cùng của View sau khi nó đã được đo đạc. Thường được gọi trong ViewGroup để đặt vị trí của các child View.

3. **onDraw (vẽ)**

   - **onDraw**: Khi View cần được vẽ lên màn hình, hệ thống sẽ gọi phương thức này. có thể gọi các phương thức Canvas được cung cấp dể vẽ (drawPath,drawText,drawColor...).

4. **onTouchEvent (sự kiện chạm vào View)**

   - **onTouchEvent: Các phương thức này được gọi khi người dùng tương tác với View (nhấn, vuốt, chạm vào).

5. **onDetachedFromWindow (Hủy)**

   - **onDetachedFromWindow**: Khi View bị gỡ bỏ khỏi cấu trúc cây View, phương thức này được gọi. Thường được sử dụng để giải phóng tài nguyên hoặc dừng các hoạt động không cần thiết.


