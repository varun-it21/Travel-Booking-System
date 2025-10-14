<%@ page import="java.util.List" %>
<%@ page import="travel.Bookings" %>
<%
    List<Bookings> bookings = (List<Bookings>) request.getAttribute("bookings");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>View Bookings - Admin</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  
  <style>
    body { font-family: 'Poppins', sans-serif; background: #f0f2f5; margin: 0; }

    /* Sidebar */
    .sidebar {
      position: fixed;
      top: 60px;
      left: 0;
      width: 220px;
      height: calc(100% - 60px);
      background: #FFD600;
      color: #fff;
      padding-top: 20px;
    }
    .sidebar h3 { text-align: center; margin-bottom: 30px; font-size: 1.5rem; font-weight: 600; }
    .sidebar a { display: block; color: #fff; padding: 15px 25px; text-decoration: none; font-weight: 500; border-left: 4px solid transparent; transition: all 0.3s; }
    .sidebar a:hover { background: #f5ff2e; border-left: 4px solid #ffffff; color: black; }

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
    .top-nav img { width: 40px; height: 40px; border-radius: 50%; cursor: pointer; border: 2px solid #004aad; }

    /* Main content */
    .main-content {
      margin-left: 220px;
      margin-top: 60px;
      padding: 30px;
      max-width: calc(100% - 240px);
    }

    .card { border-radius: 12px; box-shadow: 0 6px 18px rgba(0,0,0,0.1); background: #fff; padding: 25px; margin-bottom: 30px; }

    table { width: 100%; }
    th, td { text-align: center; vertical-align: middle; }

    @media(max-width: 768px) {
      .sidebar { width: 180px; }
      .main-content { margin-left: 180px; max-width: calc(100% - 200px); padding: 20px; }
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
    <a class="sn" href="add.html"><i class="fas fa-plus"></i> Book Package</a>
<a class="sn" href="Viewbooking"><i class="fas fa-file-alt"></i> View Bookings</a>
<a class="sn" href="queries.html"><i class="fas fa-question-circle"></i> User Queries</a>
<a class="sn" href="Contacted"><i class="fas fa-phone"></i> Contacted Users</a>
  </div>

  <!-- Main Content -->
  <div class="main-content">
    <div class="card">
      <h3 class="mb-4">All Bookings</h3>
       
      <div class="table-responsive">
        <table class="table table-striped table-bordered">
<thead class="table-dark">
<tr>
<th>Booking ID</th><th>User ID</th><th>Package Name</th><th>Full Name</th><th>Email</th>
<th>Phone</th><th>Travel Date</th><th>Adults</th><th>Children</th><th>Special Requests</th>
<th>Booking Date</th><th>Booking Type</th><th>Total Price</th>
</tr>
</thead>
<tbody>
<%
    if (bookings != null && !bookings.isEmpty()) {
        for (Bookings b : bookings) {
%>
<tr>
    <td><%= b.getBookingId() %></td>
    <td><%= b.getUserId() %></td>
    <td><%= b.getPackageName() %></td>
    <td><%= b.getFullName() %></td>
    <td><%= b.getEmail() %></td>
    <td><%= b.getPhone() %></td>
    <td><%= b.getTravelDate() %></td>
    <td><%= b.getAdults() %></td>
    <td><%= b.getChildren() %></td>
    <td><%= b.getSpecialRequests() %></td>
    <td><%= b.getBookingDate() %></td>
    <td><%= b.getBookingType() %></td>
    <td><%= b.getTotalPrice() %></td>
</tr>
<%
        }
    } else {
%>
<tr>
    <td colspan="13">No bookings found.</td>
</tr>
<%
    }
%>
</tbody>
</table>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
