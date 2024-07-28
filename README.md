# Các phương thức sử lí chạm (touch)

1. **onInterceptTouchEvent( trên ViewGroup)**
   - **Mô tả:**  Phương thức này được sử dụng bởi ViewGroup để quyết định xem nó có nên chặn sự kiện chạm và tự xử lý nó hay không, hoặc chuyển nó xuống các view con.
   - **Trả về (`return`):**
     - `true`: Sự kiện chạm sẽ bị chặn lại tại ViewGroup và không được truyền xuống cho các child view.
     - `flase`: Sự kiện chạm sẽ được truyền xuống cho các child view. Chúng sẽ lần lượt kiểm tra xem có child view nào muốn xử lý sự kiện này hay không.
   
2. **dispatchTouchEvent**
   - **Mô tả:**Tác dụng phân phối sự kiện chạm, xác định `View` có quan tâm (cần sử lí) sự kiện chạm này hay không.
   -  **Trả về (`return`):**
     - `true`: Xác định `View` sẽ sử lí sự kiện chạm 
     - `flase`: Sẽ dừng không quan tâm đến sự kiện chạm `ViewGroup` cha của nó sẽ sử lí hoặc phân phối cho `View` con khác.

3. **onTouchEvent**
   - **Mô tả:** Sử lí sự kiện chạm trên  `View`.
   
#### Về cơ bản cách sử dụng `onInterceptTouchEvent` và `dispatchTouchEvent` nếu `ViewGroup` muốn sử lí sự kiện và không muốn phân phối cho `View` con thì trong `onInterceptTouchEvent` trả về `true`. Nếu `View` không muốn sử lí sự kiện chạm và nhường cho  `View` nằm bên dưới nó hoặc `ViewGroup` cha sử lí thì trong `dispatchTouchEvent`  trả về  `false`

