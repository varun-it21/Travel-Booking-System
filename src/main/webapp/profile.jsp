<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("email") == null) {
        response.sendRedirect("login.html?msg=login_required");
        return;
    }
%>
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>User Profile - TravelGo</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
  <div class="container">
     <a href="index.html"><img src="assets/logo.png" alt="TravelGo" width="100" class="me-2"></a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbars"
      aria-controls="navbars" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end " id="navbars">
      <ul class="navbar-nav mb-2 mb-lg-0 gap-3">
        <li class="nav-item"><a class="nav-link" href="home.html">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="destinations.html">Destinations</a></li>
        <li class="nav-item"><a class="nav-link" href="mybooking.html">My Bookings</a></li>
        <li class="nav-item"><a class="nav-link" href="About.html">About us</a></li>
      </ul>
      <a href="profile.jsp" class="ms-3">
        <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="Profile"
          class="rounded-circle " width="35" height="35">
      </a>
    </div>
  </div>
</nav>
<div class="container mt-5">
  <div class="card shadow-lg">
    <div class="card-header bg-primary text-white">
      <h3>User Profile</h3>
    </div>
    <div class="card-body">
      <p><strong>User ID:</strong> <%= session1.getAttribute("user_id") %></p>
      <p><strong>Full Name:</strong> <%= session1.getAttribute("name") %></p>
      <p><strong>Email:</strong> <%= session1.getAttribute("email") %></p>
      <p><strong>Phone:</strong> <%= session1.getAttribute("phone") %></p>
      <p><strong>City:</strong> <%= session1.getAttribute("city") %></p>
      <p><strong>Created At:</strong> <%= session1.getAttribute("created_at") %></p>

      <!-- Edit Profile Form -->
      <button class="btn btn-warning" data-bs-toggle="collapse" data-bs-target="#editForm">Edit Profile</button>

      <div id="editForm" class="collapse mt-3">
        <form method="post" action="Profile">
          <input type="hidden" name="userId" value="<%= session1.getAttribute("user_id") %>">

          <div class="mb-3">
            <label class="form-label">Full Name</label>
            <input type="text" class="form-control" name="name" value="<%= session1.getAttribute("name") %>" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email" value="<%= session1.getAttribute("email") %>" required>
          </div>
          <div class="mb-3">
            <label class="form-label">Phone</label>
            <input type="text" class="form-control" name="phone" value="<%= session1.getAttribute("phone") %>" required>
          </div>
          <div class="mb-3">
            <label class="form-label">City</label>
            <input type="text" class="form-control" name="city" value="<%= session1.getAttribute("city") %>" required>
          </div>
          <button type="submit" class="btn btn-success">Save Changes</button>
        </form>
      </div>
    </div>
  </div>
</div>
<br>
<footer class="bg-dark text-light pt-5 pb-3 mt-auto">
  <div class="container">
    <div class="row g-4">
      
      <!-- Brand Info -->
      <div class="col-md-6 col-lg-4">
        <h4 class="fw-bold text-warning">TravelGo</h4>
        <p class="small">
          Your trusted companion for hassle-free travel planning. Explore, book, and enjoy unforgettable journeys with ease.
        </p>
        <p class="small mb-0">© <span id="year"></span> TravelGo Pvt Ltd. All rights reserved.</p>
      </div>

      <!-- Quick Links -->
      <div class="col-md-6 col-lg-2">
        <h6 class="fw-bold mb-3">Quick Links</h6>
        <ul class="list-unstyled">
          <li><a style="text-decoration:none; color:#bbb;" href="destinations.html" class="footer-link">Destinations</a></li>
          <li><a style="text-decoration:none; color:#bbb;" href="terms.html" class="footer-link">Terms & Conditions</a></li>
          <li><a style="text-decoration:none; color:#bbb;" href="privacy.html" class="footer-link">Privacy Policy</a></li>
          <li><a style="text-decoration:none; color:#bbb;" href="contact.html" class="footer-link">Contact Us</a></li>
          <li><a style="text-decoration:none; color:#bbb;" href="About.html" class="footer-link">About Us</a></li>
        </ul>
      </div>

      <!-- Social Media -->
      <div class="col-md-12 col-lg-4 text-lg-end">
        <h6 class="fw-bold mb-3">Connect with Us</h6>
        <a href="#" class="btn btn-outline-light btn-sm rounded-circle me-2">
          <i class="bi bi-facebook"></i>
        </a>
        <a href="#" class="btn btn-outline-light btn-sm rounded-circle me-2">
          <i class="bi bi-twitter"></i>
        </a>
        <a href="#" class="btn btn-outline-light btn-sm rounded-circle me-2">
          <i class="bi bi-instagram"></i>
        </a>
        <a href="#" class="btn btn-outline-light btn-sm rounded-circle">
          <i class="bi bi-youtube"></i>
        </a>
      </div>

    </div>
  </div>
</footer>

<% if (request.getAttribute("message") != null) { %>
    <script>
        alert("<%= request.getAttribute("message") %>");
    </script>
<% } %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js">
const urlParams = new URLSearchParams(window.location.search);
</script>
</body>
</html>
