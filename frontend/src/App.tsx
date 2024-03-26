import { Toaster } from "react-hot-toast"
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CustomerLayout from "./pages/customer/layouts/CustomerLayout";
import Home from "./pages/customer/Home";
import Movies from "./pages/customer/movie/Movies";
import AdminLayout from "./pages/admin/layouts/AdminLayout";
import Dashboard from "./pages/admin/Dashboard";
import Member from "./pages/customer/Member";
import MovieDetails from "./pages/customer/movie/MovieDetails";

function App() {

  return (
    <>
      <Toaster position="top-center" reverseOrder={false}/>
      <BrowserRouter>
        {/* Customer Routes */}
        <Routes>
          <Route path="/" element={<CustomerLayout/>}>
            <Route index element={<Home/>}/>
            <Route path="/phim" element={<Movies/>}/>
            <Route path="/chi-tiet-phim/:id" element={<MovieDetails/>}/>
            <Route path="/thanh-vien" element={<Member/>}/>
          </Route>
        </Routes>
        {/* Admin routes */}
        <Routes>
          <Route path="/admin" element={<AdminLayout/>}>
            <Route index element={<Dashboard/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App;
