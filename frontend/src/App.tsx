import { Toaster } from "react-hot-toast"
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CustomerLayout from "./layouts/CustomerLayout";
import Home from "./pages/customer/Home";
import Movies from "./pages/customer/Movies";
import AdminLayout from "./layouts/AdminLayout";
import Dashboard from "./pages/admin/Dashboard";

function App() {

  return (
    <>
      <Toaster position="top-center" reverseOrder={false}/>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<CustomerLayout/>}>
            <Route index element={<Home/>}/>
            <Route path="/phim" element={<Movies/>}/>
          </Route>
          <Route path="/admin" element={<AdminLayout/>}>
            <Route index element={<Dashboard/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App;
