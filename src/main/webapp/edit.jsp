<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Edit Booking - Admin</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      font-family: 'Poppins', sans-serif;
      background: #f0f2f5;
      margin: 0;
    }

    /* Sidebar */
    .sidebar {
      position: fixed;
      top: 60px; /* Leave space for top navbar */
      left: 0;
      width: 220px;
      height: calc(100% - 60px);
      background: #FFD600; /* User theme color */
      color: #fff;
      padding-top: 20px;
    }
    .sidebar h3 {
      text-align: center;
      margin-bottom: 30px;
      font-size: 1.5rem;
      font-weight: 600;
    }

    .sidebar a {
      display: block;
      color: #fff;
      padding: 15px 25px;
      text-decoration: none;
      font-weight: 500;
      border-left: 4px solid transparent;
      transition: all 0.3s;
    }
    .sidebar a:hover {
      background: #f5ff2e;
      border-left: 4px solid #ffffff;
      
    }

    .sn:hover{
        color: black;
    }


    /* Top Navbar */
    .top-nav {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 60px;
      background: #fff;
      display: flex;
      justify-content: flex-end;
      align-items: center;
      padding: 0 30px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
      z-index: 1000;
    }
    .top-nav img {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      cursor: pointer;
      border: 2px solid #004aad;
    }

    /* Main Content
    .main-content {
      margin-left: 220px;
      margin-top: 60px;
      padding: 30px;
    }
    .main-content h2 {
      margin-bottom: 15px;
      color: #004aad;
    }
    .main-content p {
      color: #333;
      font-size: 1rem;
    }

    @media(max-width: 768px) {
      .sidebar { width: 180px; }
      .main-content { margin-left: 180px; padding: 20px; }
    } */

    .main-content {
  margin-left: 220px;   /* push right to avoid sidebar */
  margin-top: 60px;     /* push down to avoid top navbar */
  padding: 30px;
  max-width: calc(100% - 240px); /* ensures content doesn’t go behind sidebar */
}

.card {
  border-radius: 12px;
  box-shadow: 0 6px 18px rgba(0,0,0,0.1);
  background: #fff;
  padding: 25px;
  margin-bottom: 30px;
}

/* Ensure form fields stretch correctly */
.form-control,
.form-select,
textarea {
  width: 100%;
  border-radius: 8px;
  padding: 10px;
}

/* Responsive */
@media(max-width: 768px) {
  .sidebar { width: 180px; }
  .main-content { 
    margin-left: 180px; 
    max-width: calc(100% - 200px);
    padding: 20px; 
  }
}
  </style>
</head>
<body>

  <!-- Top Navbar -->
  <a href="adminprofile.html" class="top-nav">
    <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="Profile">
  </a>

  <!-- Sidebar -->
  <div class="sidebar">
    <h3>Admin</h3>
    <a class="sn" href="add.html">➕ Book Package</a>
    <a class="sn" href="viewbooking">📑 View Bookings</a>
    <a class="sn" href="queries.html">❓ User Queries</a>
    <a class="sn" href="contacted.html">📞 Contacted Users</a>
  </div>

  <!-- Main Content -->
  <div class="main-content">
    <!-- Search Card -->
    <div class="card">
      <h2 class="text-warning">Search Booking</h2>
      <form action="Edit" method="post" class="mb-4">
    <input type="hidden" name="action" value="search">
    <div class="input-group">
      <input type="tel" name="search_phone" class="form-control" placeholder="Enter phone number" required>
      <button class="btn btn-warning" type="submit">Search</button>
    </div>
  </form>
    </div>

    <!-- Edit Form Card -->
    <div class="card">
    
    <%
    String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
    if (error != null) { %>
      <div class="alert alert-danger"><%= error %></div>
  <% } if (success != null) { %>
      <div class="alert alert-success"><%= success %></div>
  <% } %>

  <!-- Edit Form (only show if search success) -->
  <%
    if (request.getAttribute("full_name") != null) {
  %>
  
      <h2 class="mb-3 text-warning">✏️ Edit Booking</h2>
  <form action="Edit" method="post">
    <input type="hidden" name="action" value="update">

    <div class="mb-3">
      <label class="form-label">Package</label>
      <input type="text" name="package_name" class="form-control" value="<%= request.getAttribute("package_name") %>" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Full Name</label>
      <input type="text" name="full_name" class="form-control" value="<%= request.getAttribute("full_name") %>" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Email</label>
      <input type="email" name="email" class="form-control" value="<%= request.getAttribute("email") %>" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Phone</label>
      <input type="tel" name="phone" class="form-control" value="<%= request.getAttribute("phone") %>" readonly>
    </div>

    <div class="mb-3">
      <label class="form-label">Travel Date</label>
      <input type="date" name="travel_date" class="form-control" value="<%= request.getAttribute("travel_date") %>" required>
    </div>

    <div class="row mb-3">
      <div class="col">
        <label class="form-label">Adults</label>
        <input type="number" name="adults" class="form-control" value="<%= request.getAttribute("adults") %>" required>
      </div>
      <div class="col">
        <label class="form-label">Children</label>
        <input type="number" name="children" class="form-control" value="<%= request.getAttribute("children") %>">
      </div>
    </div>

    <div class="mb-3">
      <label class="form-label">Total Price</label>
      <input type="text" name="total_price" class="form-control" value="<%= request.getAttribute("total_price") %>" readonly>
    </div>

    <div class="mb-3">
      <label class="form-label">Special Requests</label>
      <textarea name="special_requests" class="form-control"><%= request.getAttribute("special_requests") %></textarea>
    </div>

    <button type="submit" class="btn btn-warning w-100">Update Booking</button>
  </form>
  <% } %>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
